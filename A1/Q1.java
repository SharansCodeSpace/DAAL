// You are given two sorted array, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order

public class Q1 {
    public static void merge(int[] A, int[] B, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastA + lastB - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && A[indexA] > B[indexB]) {
                A[indexMerged] = A[indexA];
                indexA--;
            } else {
                A[indexMerged] = B[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 1;
        A[1] = 3;
        A[2] = 5;
        A[3] = 7;
        A[4] = 9;

        int[] B = { 2, 4, 6, 8, 10 };

        merge(A, B, 5, 5);

        for (int i = 0; i < 10; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}