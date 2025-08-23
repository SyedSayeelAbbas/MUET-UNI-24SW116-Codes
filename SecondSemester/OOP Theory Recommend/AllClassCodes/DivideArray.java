//Q1: Divide an array in two parts/arrays. The array contains 10 elements.
// Split it in such a way so that it may show two arrays having 5 elements
// in each using two loops.
// The elements of an array are 1,2,3,4,5,6,7,8,9 and 10. The array must be 2d.
public class DivideArray {
    public static void main(String[] args) {
        int [][]arr1={{1,2,3,4,5},{6,7,8,9,10}};
        int []arr2=new int[5];
        int []arr3=new int[5];
        for(int i=0;i<2;i++)
        {
            for (int j=0;j<5;j++)
            {
                if(i==0)
                {
                    arr2[j]=arr1[i][j];
                }
                else if(i==1)
                {
                    arr3[j]=arr1[i][j];
                }
            }
        }
        //OR
//        for(int i=0;i<5;i++)
//        {
//            arr2[i]=arr1[0][i];
//            arr3[i]=arr1[1][i];
//         }
        System.out.println("Array 2\t| Array 3");
        for (int a=0;a<5;a++)
        {
            System.out.println(arr2[a]+"\t\t|\t"+arr3[a]);
        }
    }
}
