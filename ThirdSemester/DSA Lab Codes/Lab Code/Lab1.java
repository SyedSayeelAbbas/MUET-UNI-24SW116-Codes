class DynArray{
    private int arr[];
    private int size = 0,check = 0;

    public DynArray(int size){
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

}

public class Lab1 {
    public static void main(String[] args) {
        DynArray d1 = new DynArray(1);
        d1.display();
        d1.add(12);
        d1.display();
        d1.add(12);
        d1.display();
        d1.add(1);
        d1.display();
    }
}
//Delete last element
//return all the indexes where 30 is found
