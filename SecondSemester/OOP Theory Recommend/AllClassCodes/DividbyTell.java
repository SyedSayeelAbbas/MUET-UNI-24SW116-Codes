import java.util.Scanner;

public class DividbyTell {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter how many elements you want to split from 1-100: ");
        int elsl = in.nextInt();

        System.out.print("Enter how many splits you want for the elements you typed: ");
        int colsl = in.nextInt();

        if (elsl * colsl > 100) {
            System.out.println("Error: The total number of elements exceeds 100. Please enter valid values.");
            return;
        }

        int[] arr1 = new int[100];
        for (int i = 0; i < 100; i++) {
            arr1[i] = i + 1;
        }

        int[][] arr2 = new int[colsl][elsl];
        int index = 0;

        for (int i = 0; i < colsl; i++) {
            for (int j = 0; j < elsl; j++) {
                arr2[i][j] = arr1[index++];
            }
        }

        // Displaying the 2D array
        System.out.println("Resulting 2D Array:");
        for (int i = 0; i < colsl; i++) {
            for (int j = 0; j < elsl; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
