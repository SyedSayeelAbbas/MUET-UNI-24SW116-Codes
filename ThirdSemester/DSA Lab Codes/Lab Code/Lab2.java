package SirNaveen;

import java.util.List;
import java.util.ArrayList;

public class Lab2 {

    public static int SearchBinary(int [] a,int target){
        int low = 0, high = a.length - 1;
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

    public static int[] findNeighbours(int[] a, int index) {
        if (index < 0 || index >= a.length) {
            throw new IllegalArgumentException("Invalid index");
        }

        int target = a[index];
        List<Integer> neighbours = new ArrayList<>();

        // Move left pointer to start of block
        int left = index;
        while (left - 1 >= 0 && a[left - 1] == target) {
            left--;
        }

        // Move right pointer to end of block
        int right = index;
        while (right + 1 < a.length && a[right + 1] == target) {
            right++;
        }

        // Collect the block from left to right
        for (int i = left; i <= right; i++) {
            neighbours.add(a[i]);
        }

        // Convert to array
        int[] result = new int[neighbours.size()];
        for (int i = 0; i < neighbours.size(); i++) {
            result[i] = neighbours.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 3, 3, 5, 3};

        System.out.println("Binary Search index for 4: " + SearchBinary(arr, 4));

        int[] save = findNeighbours(arr, 2); // index 2 = value 3
        System.out.println("Neighbours:");
        for (int i : save) {
            System.out.println(i);
        }
    }
}
