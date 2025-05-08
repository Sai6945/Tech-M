package Day5;

import java.util.*;

//Course class
class Course implements Comparable<Course> {
 String courseName;

 public Course(String courseName) {
     this.courseName = courseName;
 }

 @Override
 public int compareTo(Course other) {
     return this.courseName.compareTo(other.courseName);
 }

 @Override
 public String toString() {
     return courseName;
 }
}

public class UniversityEnrollment {
 private LinkedList<Course> courses = new LinkedList<>();

 public void enrollCourse(String courseName) {
     courses.add(new Course(courseName));
 }

 public void dropCourse(String courseName) {
     Iterator<Course> iterator = courses.iterator();
     while (iterator.hasNext()) {
         if (iterator.next().courseName.equals(courseName)) {
             iterator.remove();
             return;
         }
     }
 }

 public void listCourses() {
     Collections.sort(courses);
     System.out.println("Enrolled Courses:");
     for (Course c : courses) {
         System.out.println(c);
     }
 }

 public void navigateCourses() {
     ListIterator<Course> iterator = courses.listIterator();
     System.out.println("\nForward Navigation:");
     while (iterator.hasNext()) {
         System.out.println(iterator.next());
     }
     
     System.out.println("\nBackward Navigation:");
     while (iterator.hasPrevious()) {
         System.out.println(iterator.previous());
     }
 }

 public static void main(String[] args) {
     UniversityEnrollment ue = new UniversityEnrollment();
     ue.enrollCourse("Mathematics");
     ue.enrollCourse("Physics");
     ue.enrollCourse("Computer Science");
     ue.enrollCourse("History");

     System.out.println("\nBefore Sorting:");
     ue.listCourses();
     
     ue.dropCourse("Physics");
     System.out.println("\nAfter Dropping 'Physics':");
     ue.listCourses();
     
     ue.navigateCourses();
 }
}
