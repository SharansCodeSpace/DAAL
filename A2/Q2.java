// Link - https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/candy-in-the-box-75b63839/

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            System.out.println(findBoxIndex(N, K));
        }

        sc.close();
    }

    private static int findBoxIndex(int N, int K) {
        int cycleLength = 2 * (N - 1);

        int pos = (K - 1) % cycleLength;

        if (pos < N)
            return pos + 1;
        else
            return N - (pos - N + 1);
    }
}
