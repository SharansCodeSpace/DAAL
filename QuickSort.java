class QuickSort {
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        
        for (int j = low + 1; j<= high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;

        return i;        
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5, 3, 4, 2, 6 };
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}