package SirNaveenTask;

public class DemoMain {
    public static void main(String[] args) {
//        Demo d1=new Demo();
//        Demo d2=new Demo(1,4);
//        d1.add();
//        d1.add(6,5);
//        d2.add();
//        d2.add(9,4);
        STUDENT s1=new STUDENT("sayeel",116);
        STUDENT s2=new STUDENT("sahil",118);
        STUDENT s3=new STUDENT("sakeel",119);
        TEACHER t1=new TEACHER("ty");
        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);
        t1.search(119);
    }
}
