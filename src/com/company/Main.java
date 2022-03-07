/*
Scenario: You are a Database Administrator for a university and need to
create an application to manage student enrollments and balance.
Your application should do the following:
 Ask the user how many new students will be added to the database
 The user should be prompted to enter the name and year for each student
 The student should have a 5-digit unique ID, with the first number being their grade level
 A student can enroll in the following courses:
History 101
Mathematics 101
English 101
Chemistry 101
Computer Science 101
 Each course costs $600 to enroll
 The student should be able to view their balance and pay the tuition
 To see the status of the student, we should see their name, ID, courses enrolled, and bala
 */
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

//        Student student = new Student();
//        student.enroll_to_courses();
//        student.coursePayment();
//        System.out.println(student.displayInformation());

	     // ask number of users(students) to be added
        System.out.print("Enter number of students to enroll at SM college: ");
       int number_of_students = input.nextInt();

       //create array of objects
        Student[] students = new Student[number_of_students];

        //Create number of new users(students)
        for (int i = 0; i < number_of_students; i++){
            students[i] = new Student();
            students[i].enroll_to_courses();
            students[i].coursePayment();
        }

        //Display all the students information
        for (int i = 0; i < number_of_students; i++){
            System.out.println(students[i].displayInformation());
        }

    }
}
