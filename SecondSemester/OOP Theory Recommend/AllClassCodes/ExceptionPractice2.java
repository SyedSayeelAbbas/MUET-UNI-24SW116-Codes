public class ExceptionPractice2 {
    public static void main(String[] args) {
        int[]a=new int[5];

        try{
            System.out.println(a[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println(e.getCause());
        }
    }
}
