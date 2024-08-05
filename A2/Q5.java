// Implement Linear Search Algorithm in Java.

public class Q5 {
    public static void main(String[] args) {
        int arr[] = {10, 239, 53, 78, 1, 98, 223};

        int key = 78;

        int index = linearSearch(arr, key);

        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + index);
        }
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
