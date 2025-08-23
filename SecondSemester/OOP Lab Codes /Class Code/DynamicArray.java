package SirNaveenTask;

public class DynamicArray {
    private int count=0;
    private int size=0;
    private int[]arr;
    DynamicArray(int size)
    {
        this.size=size;
        arr=new int[size];
    }
    void display()
    {
        for(int a:arr)
        {
            System.out.println(a);
        }
    }
    void isfull()
    {
        if(size==count){
            System.out.println("Array is full , now it will resized");
            arr=makeDynamic();
        }
    }
    int [] makeDynamic()
    {
        int origSize=size;
        size=size*2;
        int[] dummy=new int[size];
        for(int i=0;i<origSize;i++)
        {
            dummy[i]=arr[i];
        }
        return dummy;
    }
    void add(int val)
    {
        isfull();
        arr[count]=val;
        count++;
    }
    void update(int index,int value) {
        if(index<=this.size&&index>=0)
        {
        this.arr[index]=value;
        }
        else
        {
            System.out.println("index is out of bound");
        }
    }
    void delete(int index)
    {
        int[]temp=new int [size-1];
        for (int i = 0; i < size - 1; i++) {
            if (i < index) {
                temp[i] = arr[i];
            } else {
                temp[i] = arr[i + 1];
            }
        }
        arr=temp;
        size--;
    }
}
