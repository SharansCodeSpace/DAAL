// You are given two sorted array, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order

import java.util.Scanner;

public class Q1 {
    public static void merge(int[] A, int[] B, int n, int m) {
        int i = n - 1;
        int j = m - 1;
        int k = n + m - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j--;
            }
            k--;
        } 

        while (j >= 0) {
            A[k] = B[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n + m];
        int[] B = new int[m];

        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        for (int i = 0; i < m; i++)
            B[i] = sc.nextInt();

        merge(A, B, n, m);

        for (int i = 0; i < n + m; i++)
            System.out.print(A[i] + " ");

        System.out.println();
        sc.close();
    }
}

// Input Parameters:

// Test Case 1:
// 5 5
// 1 3 5 7 9
// 2 4 6 8 10
// Output:
// 1 2 3 4 5 6 7 8 9 

// Test Case 2:
// 5 3
// 1 3 5 7 9
// 2 4 6
// Output:
// 1 2 3 4 5 6 7 9