import java.util.Scanner;
class Student {
    private byte age;
    private int rollNo;
    private String name;

    public void setAge(byte age) {
        this.age = age;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public void displayData() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student Age: " + getAge());
        System.out.println("Student Roll No: " + getRollNo());
    }
}
public class ArrayClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student[] section1 = new Student[2];

        for (int i = 0; i < 2; i++) {
            section1[i] = new Student();

            System.out.println("Enter Student Age:");
            byte age = input.nextByte();
            section1[i].setAge(age);
            System.out.println("Enter Student Roll No:");
            int rollNo = input.nextInt();
            section1[i].setRollNo(rollNo);
            input.nextLine();
            System.out.println("Enter Student Name:");
            String name = input.nextLine();
            section1[i].setName(name);
        }
        System.out.println("\nStudent Details:");
        for (int i = 0; i < 2; i++) {
            section1[i].displayData();
            System.out.println("-----------------");
        }
        input.close();
    }
}
