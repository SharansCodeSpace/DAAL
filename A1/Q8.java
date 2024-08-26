// Imagine you are reading in stream of integers. Periodically, you wish to be able to look up the rank of number x (the number of values less than or equal to x). Implement the data structures and algorithms to support these operations. That is, Implement the method track (int x), which is called when each number is generated, and the method getRankOfNumber (int x), which return the number of values less than or equal to x (not including x itself).
// EXAMPLE
// Stream (in order of appearance) : 5, 1, 4, 4, 5, 9, 7, 13, 3
// getRankOfNumber(1) = 0
// getRankOfNumber(3) = 1
// getRankOfNumber(4) = 3

import java.util.Arrays;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int stream[] = new int[n];
        for (int i = 0; i < n; i++) {
            stream[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(stream);

        System.out.println(getRankOfNumber(stream, 1));
        System.out.println(getRankOfNumber(stream, 3));
        System.out.println(getRankOfNumber(stream, 4));
        System.out.println(getRankOfNumber(stream, 9));
    }

    private static int getRankOfNumber(int stream[], int x) {
        int left = 0;
        int right = stream.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stream[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
