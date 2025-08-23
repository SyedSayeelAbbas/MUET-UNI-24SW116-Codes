// package FinalExamPrograms;

import java.util.ArrayList;

class Professors {
    private String name;
    private University uni;

    Professors(String name, University uni) {
        this.name = name;
        this.uni = uni;
    }

    public void setProfUniName(String uniName) {
        this.uni.setUniName(uniName);
    }

    public void setProfName(String profName) {
        this.name = profName;
    }

    public String getProfName() {
        return name;
    }

    public String getProfUniName() {
        return uni.getUniName();
    }

    public String toString() {
        return "Professor Name: " + name + "\nUniversity: " + getProfUniName();
    }
}

class Students {
    private String name;
    private University uni;
    private Department dep;

    Students(String name, University uni, Department dep) {
        this.name = name;
        this.uni = uni;
        this.dep = dep;
    }

    public void setStudentUniName(String uniName) {
        this.uni.setUniName(uniName);
    }

    public void setStudentDepName(String depName) {
        this.dep.setDepName(depName);
    }

    public void setStudentName(String studentName) {
        this.name = studentName;
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentUniName() {
        return uni.getUniName();
    }

    public String getStudentDepName() {
        return dep.getDepName();
    }

    public String toString() {
        return "Student Name: " + name +
                "\nUniversity: " + getStudentUniName() +
                "\nDepartment: " + getStudentDepName();
    }
}

class Department {
    private String depName;
    private ArrayList<Students> students = new ArrayList<>();

    Department(String depName) {
        this.depName = depName;
    }

    public void addStudents(Students... students) {
        for (Students s : students) {
            this.students.add(s);
        }
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void getStudents() {
        for (Students s : students) {
            System.out.println(s);
        }
    }

    public String toString() {
        return "Department: " + depName;
    }
}

class University {
    private String uniName;
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Professors> professors = new ArrayList<>();

    University(String uniName,Department d) {
        this.uniName = uniName;
        addDepartments(d);
    }

    public void addDepartments(Department... departments) {
        for (Department d : departments) {
            this.departments.add(d);
        }
    }

    public void addProfessors(Professors... profs) {
        for (Professors p : profs) {
            this.professors.add(p);
        }
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getUniName() {
        return this.uniName;
    }

    public void getDepartments() {
        for (Department d : departments) {
            System.out.println(d);
        }
    }

    public void getProfessors() {
        for (Professors p : professors) {
            System.out.println(p);
        }
    }
}

public class MainUniversity {
    public static void main(String[] args) {


        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Electrical Engineering");
        University u1 = new University("Tech University",d1);
        u1.addDepartments(d1, d2);

        Professors p1 = new Professors("Dr. Smith", u1);
        u1.addProfessors(p1);

        Students s1 = new Students("Alice", u1, d1);
        Students s2 = new Students("Bob", u1, d1);
        d1.addStudents(s1, s2);

        System.out.println("University: " + u1.getUniName());
        System.out.println("Departments:");
        u1.getDepartments();
        System.out.println("Professors:");
        u1.getProfessors();
        System.out.println("Students in " + d1.getDepName() + ":");
        d1.getStudents();
    }
}
