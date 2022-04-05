package code.elif.app.features.funcInterface.predicate;

import code.elif.app.features.funcInterface.model.User;

import java.util.Scanner;


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


}


