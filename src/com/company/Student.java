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

public class Student {

    private String first_name;
    private String last_name;
    private int grade_year;
    private String student_ID;
    private String courses = " ";
    private double tuition_balance = 0;
    private static int id = 100;
    private static int cost_of_Course = 1000;
    private  double paid_tuition = 0;


    public Student(){
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter student first name: ");
        this.first_name = input.nextLine();

        System.out.print("Enter student last name: ");
        this.last_name = input.nextLine();


        System.out.print("1- Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student year level: ");
        this.grade_year = input.nextInt();
        setStudent_ID();
    }


    //generate the ID
    private void  setStudent_ID(){
        id++;//increment id
        this.student_ID = grade_year + "" + id;
    }

    public String getStudent_ID() {
        return student_ID;
    }
    //Enroll in the courses
    public void enroll_to_courses(){
        Scanner input = new Scanner(System.in);

       do {
            System.out.print("Enter course to enroll or (Q/q to quit): ");
            String course = input.nextLine();

            if (!course.equals("q") && !course.equals("Q")){
                this.courses = courses + "\n" + course;
                this.tuition_balance += cost_of_Course;
            }else{
                break;
            }
        } while (1 != 0);
    }

    //View balance
    public void viewBalance(){
        System.out.println("Your balance: "+ this.tuition_balance);
    }

    //Pay tuition
    public void coursePayment(){

        System.out.println("\n*************** PAYMENT PROCESS ***************");
        Scanner input = new Scanner(System.in);

        viewBalance();

        System.out.print("would you like to make a payment: ");
        String answer = input.nextLine();



        if (answer.equals("yes") || answer.equals("YES")){
            System.out.print("Enter your payment: $");
            double payment = input.nextInt();
            this.tuition_balance -= payment;
           setPaid_tuition(payment);
            System.out.println("Thank you for  making the payment of $" + payment);
            viewBalance();
        }else {
            System.out.println("No payment made yet in this account!");
        }

    }

    //paid amount into the account
    public void setPaid_tuition( double pay){
        this.paid_tuition =  pay;
    }

    //show student states
    public String displayInformation(){
        System.out.println("\n*************** STUDENT INFORMATION ***************");
        return  "Student name: " + first_name + " " + last_name + "\nStudent ID: "+student_ID+ "\nGrade year: "+grade_year + "\nCourse enrolled: "+ courses +  "\nPaid: "+paid_tuition +"\nBalance: "+tuition_balance;
    }


}
