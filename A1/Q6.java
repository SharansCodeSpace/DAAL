// Given an M*N matrix in which each row and each column is sorted in ascending order, write a method to find an element.

import java.util.Arrays;

public class Q6 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int target = 10;

        System.out.println(Arrays.toString(findElement(matrix, target)));
    }

    public static int[] findElement(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return new int[]{-1, -1};
    }
}