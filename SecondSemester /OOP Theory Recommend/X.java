public class X<T, V, E> {
    T t;
    V v;
    E e;

    public X(T t, V v, E e) {
        this.t = t;
        this.v = v;
        this.e = e;
    }

    public void display() {
        System.out.println("Data of type T: " + t.getClass().getName());
        System.out.println("Value of T: " + t);
        System.out.println("Value of V: " + v);
        System.out.println("Value of E: " + e);
    }

    public static void main(String[] args) {
        X<Integer, String, Character> x1 = new X<>(10, "p", 'A');
        x1.display();
    }
}
