public class Main {

    public static void main(String [] args) {
        int [] arr = new int[50];
        int [] arr2 = new int[50];
        int j = arr.length;

        for(int i = 0 ; i < j ;i++) {
            arr[i]=(int)(Math.random() * 50) + 1;
        }


        for(int i = 0 ; i < j ;i++ ) {
            arr2[i]=arr[j-1-i];
        }

        for(int i = 0 ; i < j ;i++ ) {
            System.out.print(arr[i]+ " ");
        }


        System.out.println("Reversed");


        for(int i = 0 ; i < j ;i++ ) {
            System.out.print(arr2[i]+ " ");
        }
    }
}

