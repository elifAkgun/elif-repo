package code.elif.app.ws.mobileappws.service;

import code.elif.app.ws.mobileappws.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    public User getUser(String userId);
    public String deleteUser(String userId);
    public User createUser(User user);
    public User updateUser(String userId, User user);

}
