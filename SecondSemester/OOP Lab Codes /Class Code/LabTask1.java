package SirNaveenTask;
import java.util.Scanner;
class Fruite
{
    Scanner in=new Scanner(System.in);
    private String[] fruit;
    int size;
    int a;
    Fruite(int size)
    {
        this.size=size;
        fruit=new String[size];
    }
    public void setFruit()
    {
        System.out.println("Enter "+size+" Friuts:");
        for(int i=0;i<size;i++)
        {
            fruit[i]=in.nextLine();
        }
    }

    public void getFruit1()
    {
        System.out.println("Your "+size+" Fruites are Below:");
        for(int i=0;i<size;i++){
            System.out.println(fruit[i]);
        }
    }
    public String[] getFruit2()
    {
        return fruit;
    }
}
public class LabTask1 {
    public static void main(String[] args) {
        Fruite f1=new Fruite(3);
        f1.setFruit();
        f1.getFruit1();
    }
}
