// A circus is designing a tower routine consisting of people standing atop one another’s shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weight of each circus, write a method to compute the largest possible number of people in such tower.
// EXAMPLE:
// Input(ht,wt): (65, 100) (70, 150) (56, 90) (75,190) (60, 95) (68, 110).
// Output: The longest tower is length 6 and includes from top to bottom:
// (56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 190)

import java.util.Arrays;

public class Q7 {
    public static void main(String[] args) {
        int[][] people = {
            {65, 100},
            {70, 150},
            {56, 90},
            {75, 190},
            {60, 95},
            {68, 110}
        };

        System.out.println(findLongestTower(people));
    }    

    public static int findLongestTower(int[][] people) {
        if (people == null || people.length == 0) {
            return 0;
        }

        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return Integer.compare(p1[0], p2[0]);
            } else {
                return Integer.compare(p1[1], p2[1]);
            }
        });

        int[] dp = new int[people.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < people.length; i++) {
            for (int j = 0; j < i; j++) {
                if (people[i][0] > people[j][0] && people[i][1] > people[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
