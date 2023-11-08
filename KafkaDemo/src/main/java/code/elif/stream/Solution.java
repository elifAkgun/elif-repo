package code.elif.stream;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static code.elif.stream.Result.closestSquaredDistance;

class Result {

    public static long closestSquaredDistance(List<Integer> x, List<Integer> y) {
        int n = x.size();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }

        // Noktaları x koordinatlarına göre sırala
        points.sort((p1, p2) -> Integer.compare(p1.x, p2.x));

        // Yardımcı fonksiyonu çağırarak en yakın mesafeyi hesapla
        return closestSquaredDistanceHelper(points, 0, n - 1);
    }

    private static long closestSquaredDistanceHelper(List<Point> points, int left, int right) {
        if (right - left <= 2) {
            // Temel durum: Eğer nokta sayısı 2 veya daha az ise doğrudan kare mesafesini hesapla
            long minDistance = Long.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    long dist = squaredDistance(points.get(i), points.get(j));
                    minDistance = Math.min(minDistance, dist);
                }
            }
            return minDistance;
        }

        // Sol ve sağ yarıları ayır
        int mid = (left + right) / 2;
        Point midPoint = points.get(mid);

        // Sol yarı ve sağ yarı için en küçük mesafeyi hesapla
        long leftMin = closestSquaredDistanceHelper(points, left, mid);
        long rightMin = closestSquaredDistanceHelper(points, mid + 1, right);

        // İki yarı arasındaki en küçük mesafeyi bul
        long minDistance = Math.min(leftMin, rightMin);

        // Ortadaki çizgiyi geçen en küçük mesafeyi bul
        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points.get(i).x - midPoint.x) < Math.sqrt(minDistance)) {
                strip.add(points.get(i));
            }
        }

        // Şeritteki noktaları y koordinatlarına göre sırala
        strip.sort((p1, p2) -> Integer.compare(p1.y, p2.y));

        // Şeritteki noktalar için en küçük mesafeyi hesapla
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < Math.sqrt(minDistance); j++) {
                long dist = squaredDistance(strip.get(i), strip.get(j));
                minDistance = Math.min(minDistance, dist);
            }
        }

        return minDistance;
    }

    private static long squaredDistance(Point p1, Point p2) {
        long dx = p1.x - p2.x;
        long dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input for x coordinates
        Integer n = scanner.nextInt();
        Integer[] x = new Integer[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        // Read input for y coordinates
        int m = scanner.nextInt();
        Integer[] y = new Integer[m];
        for (int i = 0; i < m; i++) {
            y[i] = scanner.nextInt();
        }

        // Calculate the squared shortest distance and print the result
        long result = closestSquaredDistance(Arrays.asList(x), Arrays.asList(y));
        System.out.println(result);
    }
}




