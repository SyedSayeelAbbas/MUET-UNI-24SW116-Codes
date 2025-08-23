class AfterGeneric<T> {
    T o;

    AfterGeneric(T o) {
        this.o = o;
    }

    T getob() {
        return o;
    }
}

public class AfterGen {
    public static void main(String[] args) {
        Double dob = 100.5;
        AfterGeneric<Double> agent = new AfterGeneric<>(dob);
        double d = agent.getob();

        Character cob = 'a';
        AfterGeneric<Character> agent2 = new AfterGeneric<>(cob);
        char c = agent2.getob();

        AfterGeneric<?> agent3 = agent2; // ✅ fixed with wildcard
        System.out.println("agent: " + d + ", agent2: " + c);
    }
}
