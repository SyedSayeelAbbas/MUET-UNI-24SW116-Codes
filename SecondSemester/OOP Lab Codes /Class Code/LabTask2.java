package SirNaveenTask;
import java.util.Scanner;
class Fruite2
{
    Scanner in=new Scanner(System.in);
    private String[] fruit;
    int size;
    int a;
    Fruite2(int size)
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
public class LabTask2 {
    public static void main(String[] args) {
//        Fruite2 f1=new Fruite2(3);
//        f1.setFruit();
//        f1.getFruit1();
        Fruite2[] f=new Fruite2[5];
        for(int i=0;i<f.length;i++)
        {
            f[i]=new Fruite2(2);
        }

        for(int i=0;i<f.length;i++)
        {
            f[i].setFruit();
            f[i].getFruit1();
        }
    }
}
