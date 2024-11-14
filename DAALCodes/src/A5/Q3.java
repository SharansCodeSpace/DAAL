// Link - https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/bobs-quest-d65227d1/

import java.util.*;

public class Q3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        long[] res = new long[t];

        for (int t_iter = 0; t_iter < t; t_iter++) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long l = 0, r = 0;
            HashMap<Long, Long> mp = new HashMap<>();
            long cnt = 0, maxi = 0;
            boolean flag = false;

            while (r < n) {
                mp.put(a[(int) r], mp.getOrDefault(a[(int) r], 0L) + 1);

                if (mp.get(a[(int) r]) == 1) {
                    cnt++;
                }

                while (cnt > x) {
                    mp.put(a[(int) l], mp.get(a[(int) l]) - 1);
                    if (mp.get(a[(int) l]) == 0) {
                        cnt--;
                    }
                    if (a[(int) l] == y && mp.get(a[(int) l]) == 0) {
                        flag = false;
                    }
                    l++;
                }

                if (a[(int) r] == y) {
                    flag = true;
                }

                if (cnt == x && flag) {
                    maxi = Math.max(maxi, r - l + 1);
                }

                r++;
            }

            res[t_iter] = maxi;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);
        }

        sc.close();
    }
}