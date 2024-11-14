import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<Integer> lis = findLIS(arr, n);
        for (int num : lis) {
            System.out.print(num + " ");
        }
        System.out.println();
        scanner.close();
    }

    private static List<Integer> findLIS(int[] arr, int n) {
        int[] dp = new int[n];
        List<Integer> lis = new ArrayList<>();
        int len = 0;

        for (int x : arr) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
            if (i < lis.size()) {
                lis.set(i, x);
            } else {
                lis.add(x);
            }
        }
        return lis;
    }
}
