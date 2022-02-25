package code.elif.app.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Predicate;

@Getter
@Setter
public class User {
    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public boolean isValidCredentials(User user) {
        Predicate<User> p1 = (u) -> u.userName.equals(this.userName) && u.password.equals(this.password) ;
        return p1.test(user);
    }
}
