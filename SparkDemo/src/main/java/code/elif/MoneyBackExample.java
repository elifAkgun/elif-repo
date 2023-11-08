package code.elif;

import java.util.Arrays;

public class MoneyBackExample {

    public static void main(String[] args) {
        int[] banknote = {1, 5, 10, 20, 50, 100, 500};
        int amount = 660;
        int moneyCount = 0;


        while (amount != 0) {
            amount = amount - findMaxAvailableBanknote(amount, banknote);
            moneyCount++;
        }

        System.out.println(moneyCount);
    }

    private static int findMaxAvailableBanknote(int amount, int[] banknote) {
        for (int i = banknote.length-1; i > -1; i--) {
            if (amount >= banknote[i]) {
                return banknote[i];
            }
        }
        return 0;
    }
}
