// package A3;

import java.util.*;

public class Q3 {

    static class Point {
        int x, height;

        Point(int x, int height) {
            this.x = x;
            this.height = height;
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        TreeSet<Integer> heights = new TreeSet<>(Collections.reverseOrder());
        List<Point> points = new ArrayList<>();

        for (int[] building : buildings) {
            points.add(new Point(building[0], -building[2]));
            points.add(new Point(building[1], building[2]));
        }

        points.sort((a, b) -> {
            if (a.x != b.x)
                return Integer.compare(a.x, b.x);
            return Integer.compare(b.height, a.height);
        });

        int ongoingHeight = 0;

        for (Point point : points) {
            int currentPoint = point.x;
            int heightAtCurrentPoint = point.height;

            if (heightAtCurrentPoint < 0) {
                heights.add(-heightAtCurrentPoint);
            } else {
                heights.remove(heightAtCurrentPoint);
            }

            int currentHeight = heights.isEmpty() ? 0 : heights.first();

            if (ongoingHeight != currentHeight) {
                ongoingHeight = currentHeight;
                result.add(Arrays.asList(currentPoint, ongoingHeight));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] buildings = new int[n][3];

        for (int i = 0; i < n; i++) {
            buildings[i][0] = sc.nextInt();
            buildings[i][1] = sc.nextInt();
            buildings[i][2] = sc.nextInt();
        }

        List<List<Integer>> result = getSkyline(buildings);
        for (List<Integer> r : result) {
            System.out.println(r.get(0) + " " + r.get(1));
        }

        sc.close();
    }
}
