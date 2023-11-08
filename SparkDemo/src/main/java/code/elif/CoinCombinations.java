package code.elif;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinCombinations {
    public static void main(String[] args) {
        int targetAmount = 15;
        int[] coins = {1, 5, 10, 25};

        List<List<Integer>> combinations = findCombinations(targetAmount, coins);

        System.out.println("Number of Combinations: " + combinations.size());
        for (List<Integer> combination : combinations) {
            System.out.println(formatCombination(combination, coins));
        }
    }

    public static List<List<Integer>> findCombinations(int amount, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsRecursive(amount, coins, 0, new ArrayList<>(), result);
        return result;
    }

    public static void findCombinationsRecursive(int amount, int[] coins, int startIndex, List<Integer> currentCombination, List<List<Integer>> result) {
        if (amount == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (amount < 0 || startIndex >= coins.length) {
            return;
        }
        int coinValue = coins[startIndex];

        currentCombination.add(coinValue);
        findCombinationsRecursive(amount - coinValue, coins, startIndex, currentCombination, result);

        currentCombination.remove(currentCombination.size() - 1);

        findCombinationsRecursive(amount, coins, startIndex + 1, currentCombination, result);
    }

    public static String pluralizeCoinName(int coinValue, int count) {
        if (count == 1) {
            return coinValue == 5 ? "nickel" : coinValue == 10 ? "dime" : "cent";
        } else {
            return coinValue == 5 ? "nickels" : coinValue == 10 ? "dimes" : "cents";
        }
    }

    public static String formatCombination(List<Integer> combination, int[] coins) {
        Map<Integer, Integer> coinCounts = new HashMap<>();
        StringBuilder formattedCombination = new StringBuilder();

        for (int coinValue : combination) {
            coinCounts.put(coinValue, coinCounts.getOrDefault(coinValue, 0) + 1);
        }

        for (int coinValue : coins) {
            if (coinCounts.containsKey(coinValue)) {
                int count = coinCounts.get(coinValue);
                formattedCombination.append(count).append(" ").append(pluralizeCoinName(coinValue, count)).append(" and ");
            }
        }

        String result = formattedCombination.toString();
        if (result.endsWith(" and ")) {
            result = result.substring(0, result.length() - 5); // remove last and
        }

        return result;
    }


}


class CoinCombinationsDP {
    public static void main(String[] args) {
        int targetAmount = 15;
        int[] coins = {1, 5, 10, 25};

        int[] dp = new int[targetAmount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= targetAmount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println("Number of Combinations: " + dp[targetAmount]);
    }
}

class CoinCombinationsTwoDimensionDP {

    public static void main(String[] args) {
        int targetAmount = 15;
        int[] coins = {1, 5, 10, 25};

        int[][] dp = new int[coins.length + 1][targetAmount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int coin = 1; coin <= coins.length; coin++) {
            for (int j = 0; j <= targetAmount; j++) {
                if (coins[coin - 1] <= j) {
                    dp[coin][j] = dp[coin - 1][j] + dp[coin][j - coins[coin - 1]];
                } else {
                    dp[coin][j] = dp[coin - 1][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("Number of Combinations: " + dp[coins.length][targetAmount]);
    }
}



