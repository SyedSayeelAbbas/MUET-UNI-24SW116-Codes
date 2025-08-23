package SirNaveenTask;

public class OverLoadingExample {
    static public void Addition(int a,int b)
    {
        System.out.println(a+b);
    }
    static public void Addition(float a,int b)
    {
        System.out.println(a+b);
    }
    static public void Addition(int a,float b)
    {
        System.out.println(a+b);
    }
    static public void Addition(float a,float b)
    {
        System.out.println(a+b);
    }
    //Return type doesn't matter
    public static void main(String[] args) {
        Addition(1,2.3f);
    }
}
