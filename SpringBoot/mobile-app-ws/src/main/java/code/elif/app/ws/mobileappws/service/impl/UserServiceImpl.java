package code.elif.app.ws.mobileappws.service.impl;

import code.elif.app.ws.mobileappws.model.User;
import code.elif.app.ws.mobileappws.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public List<User> getUsers() {
        return  new ArrayList<>(userMap.values());
    }

    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }

    @Override
    public String deleteUser(String userId) {
        userMap.remove(userId);
        return userId;
    }

    @Override
    public User createUser(User user) {
        String userId = UUID.randomUUID().toString();
        User createdUser = new User(userId, user.getName(), user.getLastName());
        userMap.put(userId, createdUser);
        return createdUser;
    }

    @Override
    public User updateUser(String userId, User user) {
        userMap.put(userId,user);
        return user;
    }
}
