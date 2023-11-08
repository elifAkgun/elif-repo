package code.elif.stream;

import java.util.Scanner;

import static code.elif.stream.Result.closestSquaredDistance;

public class ShortestPoint {
    public static long closestSquaredDistance2(int[] x, int[] y) {
        int n = x.length;

        long minDistance = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long dist = squaredDistance(x[i] - x[j], y[i] - y[j]);
                minDistance = Math.min(minDistance, dist);
            }
        }
        return minDistance;
    }

    private static long squaredDistance(long dx, long dy) {
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input for x coordinates
        int n = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        // Read input for y coordinates
        int m = scanner.nextInt();
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            y[i] = scanner.nextInt();
        }

        // Calculate the squared shortest distance and print the result
        long result = closestSquaredDistance2(x, y);
        System.out.println(result);
    }
}
