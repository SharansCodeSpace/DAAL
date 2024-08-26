// Given a sorted array of string which is interspersed with empty string, write a method to find the location of a given string.
// EXAMPLE
// Input: find “ball” in {“at”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”,””}
// Output: 4

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLine();
        String target = sc.nextLine();

        sc.close();
        System.out.println(findString(arr, target));
    }

    public static int findString(String[] arr, String target) {
        if (arr == null || target == null || target.isEmpty()) {
            return -1;
        }
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(String[] arr, String target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid].isEmpty()) {
            int leftMid = mid - 1;
            int rightMid = mid + 1;

            while (true) {
                if (leftMid < left && rightMid > right) {
                    return -1;
                } else if (rightMid <= right && !arr[rightMid].isEmpty()) {
                    mid = rightMid;
                    break;
                } else if (leftMid >= left && !arr[leftMid].isEmpty()) {
                    mid = leftMid;
                    break;
                }
                rightMid++;
                leftMid--;
            }
        }

        if (arr[mid].equals(target)) {
            return mid;
        } else if (arr[mid].compareTo(target) < 0) {
            return search(arr, target, mid + 1, right);
        } else {
            return search(arr, target, left, mid - 1);
        }
    }
}
