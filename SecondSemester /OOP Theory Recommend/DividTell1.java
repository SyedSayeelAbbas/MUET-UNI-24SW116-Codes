import java.util.Scanner;
public class DividTell1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter how many splits for 100:");
        int splits=in.nextInt();
        int []arr1=new int[100];
        for(int i=0;i<100;i++){
            arr1[i]=i+1;
        }
        int [][]arr2=new int[splits][(100/splits)];
        int index=0;
        for(int i=0;i<splits;i++)
        {
            for(int j=0;j<(100/splits);j++)
            {
                arr2[i][j]=arr1[index++];
            }
        }
        for(int i=0;i<splits;i++)
        {
            for(int j=0;j<(100/splits);j++)
            {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
