package SirNaveen;

class DynArray1{
    private int arr[];
    private int size = 0,check = 0;

    public DynArray1(int size){
        arr=new int[size];
        this.size=size;
    }
    public void display(){
        if(check==0){
            System.out.println("Array is Empty");
        }   else {
            for(int i:arr){
                System.out.println(i);
            }
        }

    }
    public void add(int value){
        if(check==size){
            System.out.println("Array is resized");
            resize();
            add(value);
        } else {
            arr[check]=value;
            check++;
        }
    }
    private void resize(){
        int prevsize = size;
        size = size +10;
        int dummy[]=new int[size];
        for(int i = 0;i<prevsize;i++){
            dummy[i]=arr[i];
        }
        arr = dummy;
    }
    private void resize2(){
        int prevsize = size;
        size = size -1;
        int dummy[]=new int[size];
        for(int i = 0;i<prevsize;i++){
            dummy[i]=arr[i];
        }
        arr = dummy;
    }

    public int linearSearch(int val){
        if(check==0){
            System.out.println("Array is Empty");
        } else {
            for(int i = 0;i<check;i++){
                if(arr[i]==val){
                    return i;
                }
            }
        }
        return -1;
    }
    public int[] linearSearchArray(int val){
        int index=0;
        int [] arr1=new int[size];
        if(check==0){
            System.out.println("Array is Empty");
        } else {
            for(int i = 0;i<check;i++){
                if(arr[i]==val){
                    arr1[index]=val;
                    index++;
                }
            }
            return arr1;
        }
        return null;
    }
    public int delete(){
        if(check==size){
            System.out.println("Array is resized");
        } else {
            arr[check-1]=0;
            check--;
            resize2();
        }
        return 0;
    }

}

public class Lab1Task1 {
    public static void main(String[] args) {
        DynArray1 d1 = new DynArray1(10);
        System.out.println("Before Display");
        d1.add(30);
        d1.add(10);
        d1.add(30);
        d1.add(20);
        d1.add(30);
        d1.add(50);
        d1.add(30);
        d1.add(70);
        d1.add(20);
        d1.display();
        d1.delete();
        System.out.println("After Display");
        d1.display();
        System.out.println("After Array Search Found");
        int [] arr2= d1.linearSearchArray(30);
        for (int q:arr2){
            System.out.println(q);
        }
    }
}
//Delete last element
//return all the indexes where 30 is found