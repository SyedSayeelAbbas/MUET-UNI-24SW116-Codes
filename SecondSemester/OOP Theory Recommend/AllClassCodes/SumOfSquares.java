public class SumOfSquares<T extends Number> {
    T[] a;

    public SumOfSquares(T[] a) {
        this.a = a;
    }

    public double findSum() {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = a[i].doubleValue();
            d = d * d;
            sum += d;
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30, 40};
        SumOfSquares<Integer> so1 = new SumOfSquares<>(arr);
        double sum = so1.findSum();
        System.out.println("Sum of squares: " + sum);
    }
}
