package SirNaveenTask;

public class ExceptionHandling {
    static void display()
    {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        display();
        try {
            System.out.println(2/0);
        }
//        catch (ArithmeticException e) {
//            //e.printStackTrace();
//            //System.out.println(e.toString());
//            System.out.println("Error detected"+e.getMessage());
//        }
        catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.err.println("Error hai");
        }
        finally {
            System.out.println("i always run");
        }
        //Parent class will be the last in catch block (Exception e)
        //throw is use why we manulay want to make an exception

    }
}
