package code.elif.app.ws.mobileappws.service.impl;

import code.elif.app.ws.mobileappws.data.util.JPAUtil;
import code.elif.app.ws.mobileappws.data.UserRepository;
import code.elif.app.ws.mobileappws.data.entity.UserEntity;
import code.elif.app.ws.mobileappws.model.UserDTO;
import code.elif.app.ws.mobileappws.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private Map<String, UserDTO> userMap = new HashMap<>();

    public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder ) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<UserDTO> getUsers() {

        List<UserDTO> userDTOList = new ArrayList<>();

        Iterable<UserEntity> users = userRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        for (UserEntity userEntity : users){
            UserDTO userDTO  = mapper.map(userEntity, UserDTO.class);
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public UserDTO getUser(String userId) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = userRepository.findByUserId(userId);
        UserDTO userDTO  = mapper.map(userEntity, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity==null) throw  new UsernameNotFoundException(email);

        return new ModelMapper().map(userEntity,UserDTO.class);
    }

    @Override
    public String deleteUser(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        userRepository.delete(userEntity);
        return userId;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO user) {
        UserEntity existingUser = userRepository.findByUserId(userId);
        JPAUtil.copyNonNullProperties(user,existingUser);
        userRepository.save(existingUser);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO  = mapper.map(existingUser, UserDTO.class);
        return userDTO;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(userName);
        if(userEntity==null) throw  new UsernameNotFoundException(userName);
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),true,true,true,true,new ArrayList<>());
    }
}
