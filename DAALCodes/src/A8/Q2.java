import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int minRides = minimumRides(weights, n, x);
        System.out.println(minRides);
        scanner.close();
    }

    private static int minimumRides(int[] weights, int n, int x) {
        int maxState = 1 << n;
        int[] dp = new int[maxState];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int state = 0; state < maxState; state++) {
            for (int i = 0; i < n; i++) {
                if ((state & (1 << i)) == 0) {
                    int nextState = state | (1 << i);
                    int weightSum = 0;
                    for (int j = 0; j < n; j++) {
                        if ((state & (1 << j)) != 0) {
                            weightSum += weights[j];
                        }
                    }
                    weightSum += weights[i];
                    if (weightSum <= x) {
                        dp[nextState] = Math.min(dp[nextState], dp[state]);
                    } else {
                        dp[nextState] = Math.min(dp[nextState], dp[state] + 1);
                    }
                }
            }
        }
        
        return dp[maxState - 1];
    }
}
