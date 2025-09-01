package SirNaveen;

class Sort {
    public void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    public void selectionsort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Sort s = new Sort();

        int[] arr1 = {64, 25, 12, 22, 11};
        int[] arr2 = {29, 10, 14, 37, 13};

        // Insertion Sort
        System.out.println("Before Insertion Sort:");
        printArray(arr1);
        s.insertionSort(arr1);
        System.out.println("After Insertion Sort:");
        printArray(arr1);

        System.out.println();

        // Selection Sort
        System.out.println("Before Selection Sort:");
        printArray(arr2);
        s.selectionsort(arr2);
        System.out.println("After Selection Sort:");
        printArray(arr2);
    }

    // Helper method to print arrays
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
