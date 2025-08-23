import java.util.Scanner;
public class ExceptionPractice1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter Numerator:");
        int a=in.nextInt();
        System.out.print("Enter Denomerator:");
        int b=in.nextInt();
        int answer=0;
        try{
            answer=a/b;
        }catch (ArithmeticException e){
            System.err.println("Error is found"+e.getMessage());
        }

    }
}
