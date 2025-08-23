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
       Double dob = new Double(100.5);
       AfterGeneric<Double> agent = new AfterGeneric<>(dob);
       double d = agent.getob();
       Character cob = new Character('a');
       AfterGeneric<Character> agent2 = new AfterGeneric<>(cob);
       char c = agent2.getob();

       agent = agent2; // This will show compile-time error
   }
}
