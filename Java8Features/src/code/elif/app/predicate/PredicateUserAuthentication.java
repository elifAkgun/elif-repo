package code.elif.app.predicate;

import java.io.Console;
import java.util.Scanner;
import java.util.function.Predicate;



public class PredicateUserAuthentication {

    public static void main(String[] args) {

        User user = new User("john", "pass123");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please type user name : ");
        String userName = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User userInfo = new User(userName, password);

        if(user.isValidCredentials(userInfo)) {
            System.out.print("Valid credentials for the user");
        }
        else {
            System.out.print("Not authorized...");
        }
    }

    static class User {
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
}


