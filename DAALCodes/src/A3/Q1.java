// Implement algorithm to find the maximum element in an array which is first increasing and then decreasing, with time complexity O (log n).

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();

        System.out.println(findMaximum(arr, n));
    }

    public static int findMaximum(int[] arr, int n) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (left == right)
                return arr[left];

            if (right == left + 1)
                return Math.max(arr[left], arr[right]);

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return arr[mid];

            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
