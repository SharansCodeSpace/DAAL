import java.util.*;

public class Q2 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = Max(N, K, arr);
        System.out.println(result);
        
        sc.close();
    }

    static int Max(int N, int K, int[] arr) {
        int result = 0;
        int even = 0, odd = 0;
        
        // Create a list to store the differences when even and odd counts match
        List<Integer> list = new ArrayList<>();
        
        // Loop through the array to find even and odd counts
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] % 2 == 0) even++;
            else odd++;
            
            // When even and odd counts are equal, add the absolute difference to the list
            if (even == odd) {
                list.add(Math.abs(arr[i + 1] - arr[i]));
            }
        }
        
        Collections.sort(list);
        
        // Calculate the total cost and increment result based on the budget (K)
        int total = 0;
        for (int diff : list) {
            total += diff;
            if (total <= K) result++;
            else break;
        }
        
        return result;
    }
}