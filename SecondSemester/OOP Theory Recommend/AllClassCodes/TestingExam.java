public class TestingExam {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9,10};
        int [][]arr2=new int[10][10];
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++){
                arr2[i][j]=arr[j];
            }
        }
        for(int i=0;i<10;i++)
        {
            System.out.println(arr2[i][i]);
            System.out.print("\t");
        }
    }
}
