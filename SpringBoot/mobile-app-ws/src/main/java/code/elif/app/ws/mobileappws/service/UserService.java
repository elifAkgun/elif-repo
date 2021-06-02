package code.elif.app.ws.mobileappws.service;

import code.elif.app.ws.mobileappws.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<UserDTO> getUsers();
    public UserDTO getUser(String userId);
    public UserDTO getUserByEmail(String email);
    public String deleteUser(String userId);
    public UserDTO createUser(UserDTO user);
    public UserDTO updateUser(String userId, UserDTO user);

}
