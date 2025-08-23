public class ReverseDiagonal {
    public static void main(String[] args) {
        int n = 10;
        char[][] matrix = new char[n][n];

        // Fill the matrix with spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ' ';
            }
        }

        // Place numbers in the correct position
        for (int i = 0; i < n; i++) {
            matrix[i][n - 1 - i] = (char) ('0' + (n - i));
        }

        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
