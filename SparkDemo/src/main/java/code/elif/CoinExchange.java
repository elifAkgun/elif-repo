package code.elif;

import java.util.List;

public class CoinExchange {

    public static void main(String[] args) {
        int targetAmount = 100;
        int[] coins = {1, 5, 10, 25};

        System.out.println(coinExchange(coins, coins.length, targetAmount));
    }

    private static int coinExchange(int[] coins, int n, int targetAmount) {

        if (targetAmount == 0)
            return 1;
        if (targetAmount < 0)
            return 0;

        if (n <= 0 && targetAmount > 0)
            return 0;

        return coinExchange(coins, n - 1, targetAmount) + coinExchange(coins, n, targetAmount - coins[n - 1]);

    }
}


class dp {

    public static void main(String[] args) {
        int targetAmount = 15;
        int[] coins = {1, 5, 10, 25};
        numberOfCombinations(coins, targetAmount);
    }

    public static int numberOfCombinations(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (j - coins[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        for (int j = 0; j < 16; j++) {
            System.out.print(j + ", ");
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }
        return dp[n][target];
    }
}
