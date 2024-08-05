// Link - https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/employee-rating-8cd8dc10/

public class Q1 {
    public static void main(String[] args) {
        int[] workload = {8, 6, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int N = workload.length;

        System.out.println(getRating(workload, N));
    }

    private static int getRating(int[] workload, int N) {
        int rating = Integer.MIN_VALUE;
        int cnt = 0;

        for (int i : workload) {
            if (i > 6)
                cnt++;
            else {
                rating = Math.max(rating, cnt);
                cnt = 0;
            }
        }

        rating = Math.max(rating, cnt);

        return rating;
    }
}

