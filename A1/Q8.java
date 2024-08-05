// Imagine you are reading in stream of integers. Periodically, you wish to be able to look up the rank of number x (the number of values less than or equal to x). Implement the data structures and algorithms to support these operations. That is, Implement the method track (int x), which is called when each number is generated, and the method getRankOfNumber (int x), which return the number of values less than or equal to x (not including x itself).
// EXAMPLE
// Stream (in order of appearance) : 5, 1, 4, 4, 5, 9, 7, 13, 3
// getRankOfNumber(1) = 0
// getRankOfNumber(3) = 1
// getRankOfNumber(4) = 3

import java.util.ArrayList;
import java.util.List;

public class Q8 {
    public static void main(String[] args) {
        int[] stream = {5, 1, 4, 4, 5, 9, 7, 13, 3};

        for (int i : stream) {
            track(i);
        }

        System.out.println(getRankOfNumber(1));
        System.out.println(getRankOfNumber(3));
        System.out.println(getRankOfNumber(4));        
    }

    private static List<Integer> sortedList = new ArrayList<>();


    private static void track(int x) {
        int pos = findInsertPosition(x);
        sortedList.add(pos, x);
    }

    private static int getRankOfNumber(int x) {
        int left = 0;
        int right = sortedList.size() - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedList.get(mid) <= x) {
                count = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }

    private static int findInsertPosition(int x) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedList.get(mid) < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
