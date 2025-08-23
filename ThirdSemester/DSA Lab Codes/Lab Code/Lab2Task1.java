package SirNaveen;

public class Lab2Task1 {

    public static int SearchBinary(int[] a, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int exponential(int[] arr, int target) {
        if (arr[0] == target) return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }
        return SearchBinary(arr, target, i / 2, Math.min(i, arr.length - 1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 13, 15, 18, 21, 25};
        int target = 13;

        int result = exponential(arr, target);
        if (result != -1) {
            System.out.println("Found at index: " + result);
        } else {
            System.out.println("Not found");
        }
    }
    //interpolation Search
}
