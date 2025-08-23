class Gen {
    Object o;
    Gen(Object o) {
        this.o = o;
    }
    Object getob() {
        return o;
    }
}

public class BeforeGen {
    public static void main(String[] args) {
        Gen bgen1;
        Gen bgen2;
        Double dob = new Double(100.5);
        bgen1 = new Gen(dob);
        Double d = (Double) bgen1.getob();
        Character cob = new Character('F');
        bgen2 = new Gen(cob);
        char c = (Character) bgen2.getob();

        bgen1 = bgen2; // This will give error at runtime
    }
}
