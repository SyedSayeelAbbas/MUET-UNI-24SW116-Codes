package SirNaveenTask;
import java.util.ArrayList;

public class TEACHER {
    private String name;
    private ArrayList<STUDENT> students = new ArrayList<>();

    TEACHER(String name) {
        this.name = name;
    }

    public void addStudent(STUDENT s) {
        this.students.add(s);
    }

    public void search(int rollNO) {
        boolean found = false;
        for (STUDENT s : students) {
            if (s.getRollNo() == rollNO) {
                System.out.println("Yes, it has Roll NO: " + rollNO);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with Roll NO: " + rollNO);
        }
    }

    public void displayTeacher() {
        System.out.println("Name of Teacher: " + this.name);
    }
}
