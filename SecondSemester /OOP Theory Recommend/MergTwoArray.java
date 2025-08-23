public class MergTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[][] arr3 = new int[2][5]; // 2D array to store merged values

        // Merging arrays into arr3
        for (int j = 0; j < 5; j++) {
            arr3[0][j] = arr1[j]; // First row
            arr3[1][j] = arr2[j]; // Second row
        }

        // Printing the merged 2D array
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
