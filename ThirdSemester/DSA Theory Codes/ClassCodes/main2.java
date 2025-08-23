public class main2 {
    public static int termFinder(int[] arr) {


        int n = 34;
        int p =0;
        int q = arr.length-1;

        while(p<=q) {
            int i=(p+q)/2;
            if(arr[i]==n) {
                return i;
            }
            else if(arr[i]<n) {
                p = i+1;
            }
            else if(arr[i]>n) {
                q = i-1;
            }
        }
        return -1;

    }
    public static void main(String [] args) {
        int[] arr = new int[50];
        for(int i = 0 ; i < arr.length;i++) {
            arr[i]=i+1;
        }
        System.out.println(termFinder(arr));
    }
}
