package code.elif.app.funcInterface.supplier;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        generateRandomPassword();
    }

    //Length should be 8 characters
    //2,4,6,8 characters must be digit
    //1,3,5,7 characters must be uppercase letter
    private static void generateRandomPassword() {
        Supplier<String> supplierPassword = () -> {
            String password1 = "";
            String symbols = "ABCDEFGHIJKLMNOPRSTUVWXYZ@#$";

            Supplier<Integer> supplierInt = () -> (int) (Math.random() * 10);
            Supplier<Character> supplierChar = () -> {
                Random random = new Random();
                int randomIndex = random.nextInt(symbols.length());
                return symbols.charAt(randomIndex);
            };

            for (int i = 1; i < 9; i++) {
                if (i % 2 == 0) {
                    password1 += supplierInt.get();
                } else {
                    password1 += supplierChar.get();
                }

            }
            return password1;
        };

        String password = supplierPassword.get();
        System.out.println("Password is "+ password);

    }

}
