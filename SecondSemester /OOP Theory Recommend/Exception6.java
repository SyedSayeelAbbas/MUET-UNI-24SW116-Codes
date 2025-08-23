public class Exception6 {
    public static void main(String[] args) {
        int a[]=new int[10];
        int i;
        for(i=-1;i<10;i++)
        {
            try{
                a[i]=i;
                System.out.println("a["+i+"]="+a[i]);
                int k;
                k=i/(9-i);
            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println(e.getMessage());
            }catch (ArithmeticException e){
                System.err.println(e.getMessage());
            }catch (ArrayStoreException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
