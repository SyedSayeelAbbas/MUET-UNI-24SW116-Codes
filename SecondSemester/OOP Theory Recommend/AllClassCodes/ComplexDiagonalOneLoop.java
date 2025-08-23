public class ComplexDiagonalOneLoop {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        // Fill the 2D array with values
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = j + 1;
            }
        }
        int i = 0, j = 0;  // Start from (0,0)
        while (i < 10) {
            // Check if the element is on the border or diagonals
            if (i == 0 || i == 9 || j == 0 || j == 9 || i == j || i + j == 9) {
                System.out.print(arr[i][j] + " ");
            } else {
                System.out.print("  ");
            }
            j++;

            if (j == 10) {
                System.out.println();
                i++;
                j = 0;
            }
        }
    }
}
