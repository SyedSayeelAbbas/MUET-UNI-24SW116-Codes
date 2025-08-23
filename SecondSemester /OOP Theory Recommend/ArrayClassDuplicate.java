class StudentDuplicate {
    private int speed;
    private String color;

    public StudentDuplicate() {
        this.speed = 0;
        this.color = "Unknown";
    }

    public StudentDuplicate(int speed, String color) {
        this.speed = speed;
        this.color = color;
    }

    StudentDuplicate[] Dupli(StudentDuplicate b) {
        StudentDuplicate[] temp = new StudentDuplicate[10];

        for (int i = 0; i < 10; i++) {
            temp[i] = new StudentDuplicate(b.speed, b.color);
        }
        return temp;
    }
    public void display() {
        System.out.println("Speed: " + speed);
        System.out.println("Color: " + color);
    }
}
public class ArrayClassDuplicate {
    public static void main(String[] args) {
        StudentDuplicate c1 = new StudentDuplicate(100, "Red");
        StudentDuplicate[] c2 = c1.Dupli(c1);

        for (int i = 0; i < 10; i++) {
            c2[i].display();
        }
    }
}
