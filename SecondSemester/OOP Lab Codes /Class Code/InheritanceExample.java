package SirNaveenTask;
class A
{
    int a=10,b=2;
    A(int a)
    {
        this.a=a;
        System.out.println("Class A");
    }
//    void display()
//    {
//        System.out.println(a);
//    }
    int display()
    {
        System.out.println(a);
        return 0;
    }
}
class B extends A{
    int a=20;
    int b=super.b;
    B()
    {
        super(20);
        System.out.println("Class B");
    }
    void value()
    {
        System.out.println(a);
        System.out.println(super.a);
    }
    //return type of super and inheriter method should be same.
//    void display()
//    {
//        super.display();
//        System.out.println(a);
//    }
    int display()
    {
        super.display();
        System.out.println(a);
        return 0;
    }
}
public class InheritanceExample {
    public static void main(String[] args) {
//        new B().value();
//        new B().display();
        new B();
    }
}
