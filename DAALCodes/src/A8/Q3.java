import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        int[] top = new int[N];
        int[] bottom = new int[N];
        
        for (int i = 0; i < N; i++) {
            top[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < N; i++) {
            bottom[i] = scanner.nextInt();
        }
        
        int[] dp = new int[N];
        dp[0] = Math.abs(top[0] - bottom[0]);
        
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + Math.abs(top[i] - bottom[i]);
            if (i > 1) {
                dp[i] = Math.max(dp[i], dp[i - 2] + Math.abs(top[i - 1] - top[i]) + Math.abs(bottom[i - 1] - bottom[i]));
            }
        }
        
        System.out.println(dp[N - 1]);
        scanner.close();
    }
}