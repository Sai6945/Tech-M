package Day2and3;

import java.util.*;

// Student class
class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void displayStudent() {
        System.out.println(name + " - " + marks);
    }
}

public class StudentSorting {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 90),
            new Student("Charlie", 78)
        );

        // Sorting students using an anonymous inner class
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMarks(), s1.getMarks()); // Sort in descending order
            }
        });

        // Displaying sorted students
        System.out.println("Sorted Students (by Marks):");
        for (Student s : students) {
            s.displayStudent();
        }
    }
}
