import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionPractice7 {
    public static void main(String[] args) {
        int i = 0, k = 0;
        String s;
        int[] a;
        int[] b;

        System.out.println("Enter any Number From 1 to 4:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            s = br.readLine();
            i = Integer.parseInt(s); // parsing moved inside try

            try {
                if (i == 1) {
                    k = i * (i - 1); // normal multiplication
                }

                if (i == 2) {
                    a = new int[-2]; // will throw NegativeArraySizeException
                }

                if (i == 3) {
                    i = i / (i - 3); // division by zero if i==3
                }

                if (i == 4) {
                    b = new int[1];
                    b[1] = 500; // ArrayIndexOutOfBoundsException
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array Index Out of Bounds Exception: " + e.getMessage());
            } catch (NegativeArraySizeException e) {
                System.out.println("Negative Array Size Exception: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }
}
