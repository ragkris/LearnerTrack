package com.airtribe.lts.menu;

import com.airtribe.lts.entity.Student;
import com.airtribe.lts.exception.InvalidSearchException;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.service.StudentService;
import com.airtribe.lts.utilities.AppMessages;
import com.airtribe.lts.utilities.Util;

import java.util.List;

public class StudentMenu extends MenuUI {

    StudentService studentService = StudentService.getInstance();
    protected void show() {
        int choice=0;
        do{
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Deactivate Student by ID");
            System.out.println("9. Return to Main Menu");
            System.out.println("0. Exit");

            try {
                choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1 -> {

                        System.out.println("1. Adding a Student, Enter the following details...");
                        String firstname = (Util.isValidAlpha(readString("First Name : "),3,20));
                        String lastname =(Util.isValidAlpha(readString("Last Name : "),3,20));
                        String email = (Util.isValidEmail(readString("Email : ")));
                        String batch = (Util.isValidAlphaNumeric(readString("Batch : "),3,10));

                        Student student = new Student(firstname, lastname,email,batch);
                        student.setActive(true);
                        studentService.add(student);
                        System.out.println(AppMessages.SUCCESS_STUDENT_ADDED);
                    }
                    case 2 -> {
                        List<Student> students = studentService.list();

                        System.out.println("+----------+------------------------------------+----------------------+---------+-----------");
                        System.out.println("| ID       | Display Name                       |  Email               | Batch   | Status  ");
                        System.out.println("+----------+------------------------------------+----------------------+---------+-----------");

                        for (Student s : students) {
                            System.out.printf("| %-5s | %-34s |  %-19s | %-8s | %-8s \n",
                                    s.getId(),
                                    s.getDisplayName(),
                                    s.getEmail(),
                                    s.getBatch(),
                                    s.isActive()?"active":"Inactive");
                        }

                        System.out.println("+----------+------------------------------------+----------------------+---------+-----------");


                    }
                    case 3 ->{
                        String studentID=readString("Student ID : ");
                        Student s = studentService.view(studentID);

                        System.out.println("+----------+-----------------------+-------------+----------------------+---------+-----------");
                        System.out.println("| ID       | First Name            | Last Name   |  Email               | Batch   | Status  ");
                        System.out.println("+----------+-----------------------+-------------+----------------------+---------+-----------");
                        System.out.printf("| %-5s | %-21s | %-11s |  %-19s | %-8s | %-8s \n",
                                s.getId(),
                                s.getFirstName(),
                                s.getLastName(),
                                s.getEmail(),
                                s.getBatch(),
                                s.isActive()?"active":"Inactive");
                        System.out.println("+----------+-----------------------+-------------+----------------------+---------+-----------");

                    }
                    case 4 ->{
                        String studentID=readString("Student ID : ");
                        Student s =studentService.deactivate(studentID);

                        System.out.println(AppMessages.SUCCESS_STUDENT_UPDATED);
                    }
                    case 9 ->{
                        System.out.println("Back to Main Menu.");
                        start();
                    }
                    case 0 ->{
                        System.out.println("Thank you for using LTS!");
                        return;
                    }
                }

            }catch (LTSException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println(AppMessages.GENERIC_ERROR);
            }
            readString("Press ENTER to continue....");
        } while (choice != 0 && choice != 9);
    }

}
