package SirNaveenTask;

public class STUDENT {
    private String name;
    private int rollNo;

    STUDENT(String name, int rollNo) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Name: " + this.name + "\nRoll No: " + this.rollNo);
    }
}
