/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week.pkg4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LARTEK
 */
public class Week4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<Course>();

        // 1. Create courses
        System.out.print("How many courses? ");
        int numberOfCourses = input.nextInt();
        input.nextLine();

        if (numberOfCourses < 3) {
            System.out.println(
                "You must create at least 3 courses."
            );
            input.close();
            return;
        }

        for (int i = 0; i < numberOfCourses; i++) {

            System.out.print("Enter course name: ");
            String name = input.nextLine();

            System.out.print("Enter classroom capacity: ");
            int capacity = input.nextInt();
            input.nextLine();

            Course c = new Course(name, capacity);
            courses.add(c);
        }

        // 2. Display available courses
        System.out.println("\nAvailable Courses:");

        for (Course c : courses) {
            System.out.println(
                c.courseName + " - Capacity: " + c.capacity
            );
        }

        // 3. Register students
        System.out.print("How many students will register? ");
        int numberOfStudents = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.print("Enter student ID: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Enter student name: ");
            String name = input.nextLine();

            System.out.print("Enter course name: ");
            String wantedCourse = input.nextLine();

            Student student = new Student(id, name);
            boolean found = false;

            for (Course c : courses) {

                if (c.courseName.equals(wantedCourse)) {
                    found = true;

                    // Check course capacity
                    if (c.enrolledStudents.size() >= c.capacity) {
                        System.out.println("Course is full.");
                        break;
                    }

                    // Check duplicate student ID
                    boolean duplicate = false;

                    for (Student s : c.enrolledStudents) {
                        if (s.studentID == student.studentID) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println(
                            "Student already registered."
                        );
                    } else {
                        c.enrolledStudents.add(student);
                        System.out.println(
                            "Registration successful."
                        );
                    }

                    break;
                }
            }

            if (!found) {
                System.out.println("No course found with that name.");
            }
        }

        // 4. Display all courses and registered students
        System.out.println("\n===== ALL COURSES =====");

        for (Course c : courses) {
            c.displayInfo();
            System.out.println("--------------------");
        }

        input.close();  









    }
    
}
