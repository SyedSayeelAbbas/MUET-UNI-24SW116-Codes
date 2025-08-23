
public class ExceptionPractice5
{
    public static void main(String[] args) {
        int a[]=new int[10];
        for (int i=-1;i<=10;i++){
            try{
                a[i]=i;
                System.out.println("a["+i+"]="+a[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Array index is out of bound");
            }
        }
    }
}
