//Q2: Assume, there is an array of 100 elements from 0 to 99. Split
// the array into 10 arrays having 10 elements in each which means
// array of arrays. Remember, the array must be 2D.
public class DivideArrayBy100 {
    public static void main(String[] args) {
        int []arr1=new int[100];
        int [][]arr2=new int[10][10];
        for (int a=0;a<100;a++)
        {
            arr1[a]=a;
        }
        int index=0;
        for(int m=0;m<10;m++)
        {
            for(int n=0;n<10;n++){
                arr2[m][n]=arr1[index++];
            }
        }
        System.out.println("2D Array (10x10):");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println(); // Move to the next row
        }
    }
}
