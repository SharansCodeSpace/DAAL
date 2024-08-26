// Link - https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/employee-rating-8cd8dc10/

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] workload = new int[n];
        for (int i = 0; i < workload.length; i++)
            workload[i] = sc.nextInt();
        sc.close();

        System.out.println(getRating(workload, n));
    }

    private static int getRating(int[] workload, int N) {
        int rating = Integer.MIN_VALUE;
        int cnt = 0;

        for (int i : workload) {
            if (i > 6)
                cnt++;
            else {
                rating = Math.max(rating, cnt);
                cnt = 0;
            }
        }
        rating = Math.max(rating, cnt);
        return rating;
    }
}

