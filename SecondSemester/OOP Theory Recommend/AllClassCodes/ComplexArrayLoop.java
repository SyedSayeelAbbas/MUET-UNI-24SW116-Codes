public class ComplexArrayLoop {
    public static void main(String[] args) {
        int n=10;
        int[][] arr = new int[10][10];

        for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    arr[i][j] = j + 1;
                }
            }

       for(int i=0;i<10;i++)
           {
               System.out.print(arr[i][i]+"\t"+"  ");
           }
        System.out.println();
        System.out.println();
        for(int i=0;i<10;i++)
        {
            if(i<4)
                {
                System.out.print(arr[i][0]+" ");
                    for(int s=0;s<=i;s++)
                    {
                        System.out.print("\t"+"  ");
                    }
                }
            else if(i>=4 && i<8)
            {
                System.out.print(arr[i][0] + " ");
                for (int s = i; s <8; s++)
                {
                    System.out.print("\t");
                }
                System.out.print("  ");
            }
            if(i<4)
            {
                System.out.print(arr[i+1][i+1]);
            }
            if(i>=4&&i<9)
            {
                System.out.print(arr[i][8-i]);
            }
            if(i<4)
            {
            for(int r=i;r<=2;r++)
                {
                    System.out.print("\t\t");
                }
            }
            System.out.print("\t  ");
            if(i<4)
                {
                    System.out.print(arr[i+2][8-i]);
                }
            if(i<4)
                {
                    for(int t=0;t<=(i);t++)
                        {
                        System.out.print("\t");
                        }
                    System.out.println("  "+arr[i][9]);
                    System.out.println();
                }
            if(i>=4&&i<8)
                {
                    for(int o=4;o<i;o++)
                    {
                        System.out.print("\t\t");
                    }
                System.out.print(arr[i][i+1]+" ");

                }
            if(i>=4 &&i<8)
            {
                for(int t=0;t<=(7-i);t++)
                {
                    if(i==4)
                    {
                        System.out.print("   ");
                    }
                    else{
                    System.out.print("\t");}
                }
                System.out.println("  "+arr[i][9]);
                System.out.println();
            }
            if(i==8)
                {
                    for(int j=1;j<=9;j++)
                        {
                        System.out.print(arr[j][j]+"   ");
                        }
                }
        }
    }
}
