// Link - https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/candy-in-the-box-75b63839/

public class Q2 {
    public static void main(String[] args) {
        int N = 10;
        int K = 25;

        System.out.println(findBoxIndex(N, K));
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
