package com.airtribe.lts.menu;

import com.airtribe.lts.entity.Enrolment;
import com.airtribe.lts.entity.EnrolmentStatus;
import com.airtribe.lts.exception.InvalidInputException;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.service.EnrolmentService;
import com.airtribe.lts.utilities.AppMessages;
import com.airtribe.lts.utilities.Util;

import java.text.SimpleDateFormat;
import java.util.List;

public class EnrolmentMenu extends MenuUI{
    EnrolmentService enrolmentService = EnrolmentService.getInstance();
    protected  void show() {

        int choice=0;
        do{
            System.out.println("\n===== Enrolment Management =====");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrolment by Student ID");
            System.out.println("3. Change Enrolment Status");
            System.out.println("9. Return to Main Menu");
            System.out.println("0. Exit");

            try {
                choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1 -> {
                        System.out.println("1. Enrolling a student, Enter the following details...");
                        String studentID= Util.isValidIDFormat(readString("Student ID : "));
                        String courseID = Util.isValidIDFormat(readString("Course ID : "));
                        enrolmentService.enroll(studentID,courseID);
                        System.out.println(AppMessages.SUCCESS_ENROLMENT_ADDED);
                    }
                    case 2 -> {
                        String studentID= readString("Student ID : ");
                        List<Enrolment> enrolments = enrolmentService.view(studentID);

                        System.out.println("+----------+--------------+--------------+----------------+----------");
                        System.out.println("| ID       | Student ID   | Course ID    |  Date          | Status");
                        System.out.println("+----------+--------------+--------------+----------------+----------");

                        for (Enrolment e : enrolments) {
                            System.out.printf("| %-5s | %-12s | %-12s |  %-13s | %-8s \n",
                                    e.getId(),
                                    e.getStudentId(),
                                    e.getCourseId(),
                                    new SimpleDateFormat("dd-MM-yyyy").format(e.getEnrollmentDate()),
                                    e.getStatus().getValue());
                        }

                        System.out.println("+----------+--------------+--------------+----------------+----------");

                    }
                    case 3 ->{
                        String enrolId=readString("Enrolment ID : ");
                        int status=readInt("Set to Active(1) / Completed (2) / Cancelled (0) ; Enter 0, 1 or 2 : ");
                        if(status<0 || status >2) {
                            throw new InvalidInputException(AppMessages.INVALID_FIELD_VALUE);

                        }
                        else {
                            EnrolmentStatus enStatus = status==1?EnrolmentStatus.ACTIVE:status==2?EnrolmentStatus.COMPLETED:EnrolmentStatus.CANCELLED;
                            Enrolment e = enrolmentService.changeStatus(enrolId, enStatus);
                            System.out.println(AppMessages.SUCCESS_ENROLMENT_UPDATED);
                        }

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
