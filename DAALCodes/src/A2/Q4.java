// Link - https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/counting-frog-paths-1abd84d5/

import java.util.Scanner;

public class Q4 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int s = sc.nextInt();
        int T = sc.nextInt();

        int count = 0;
        for (int i = X; i <= X + s; i++)
            for (int j = Y ; j <= Y + s ; j++)
                if (i + j <= T)
                    count++;

        System.out.println(count);

        sc.close();
    }
}
