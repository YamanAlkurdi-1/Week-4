/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week.pkg4;

import java.util.ArrayList;

/**
 *
 * @author LARTEK
 */
public class Course {
     String courseName;
    int capacity;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        enrolledStudents = new ArrayList<Student>();
    }

    public void displayInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println(
            "Enrolled Students: " + enrolledStudents.size()
        );

        for (Student s : enrolledStudents) {
            s.displayInfo();
        }
}
   }