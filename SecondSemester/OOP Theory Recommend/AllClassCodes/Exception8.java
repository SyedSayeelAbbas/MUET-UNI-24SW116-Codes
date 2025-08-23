public class Exception8 {
    static public void maths(int i) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        if (i == 1) {
            System.out.println("This method throws Arithmetic Exception:");
            throw new ArithmeticException("Arithmetic Exception occurred");
        }
        if (i == 2) {
            System.out.println("This method throws ArrayIndexOutOfBound Exception:");
            throw new ArrayIndexOutOfBoundsException("Array Index Out Of Bounds Exception occurred");
        }

        // This block runs if i is not 1 or 2
        System.out.println("This Block Statement must run");
        System.out.println("HI!");
    }

    public static void main(String[] args) {
        try {
            maths(1);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try {
            maths(2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
