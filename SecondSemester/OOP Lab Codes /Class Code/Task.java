package SirNaveenTask;
import java.util.Scanner;
public class Task {
    public static void main(String[] args) {
        //Intializing Scanner object
        Scanner input= new Scanner(System.in);
        //decration of array
        int []arr1;
        //Intialization
        arr1=new int[10];//[10] give the size of array
        //Other way of Declaration
        int[]arr2=new int[5];
        //Other way of Intialization
        int[] arr3={1,2,3,4,5};
        //modification of object memory
        arr3=arr1;//Now arr3 has 10 element space

        for(int i=0;i< arr1.length;i++)
        {
            arr1[i]=input.nextInt();
        }

        //For Each LOOP
        for(int a:arr3)
        {
            System.out.print(a+" ");
        }
        //2D Array
        int [][]arr4={{1,2},{3,4}};
        //2D For Each LOOP
        for(int [] row:arr4){
            for(int colume: row)
            {
                System.out.print(colume);
            }
        }
        //3D Array
        int [][][]arr5= {
                    {{1,2},{3,4}}
                    ,{{5,6},{7,8}}
                        };
        //3D Array For Each Loop
        for(int [][] outerRow:arr5){
            for(int[] inerRow: outerRow)
            {
                for(int col:inerRow){
                System.out.print(col+" ");}
            }
        }
    }
}
