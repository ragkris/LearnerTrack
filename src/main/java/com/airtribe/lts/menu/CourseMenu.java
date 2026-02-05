package com.airtribe.lts.menu;

import com.airtribe.lts.entity.Course;
import com.airtribe.lts.exception.InvalidInputException;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.service.CourseService;
import com.airtribe.lts.utilities.AppMessages;
import com.airtribe.lts.utilities.Util;

import java.util.List;

public class CourseMenu extends MenuUI{

    CourseService courseService = CourseService.getInstance();
    protected  void show() {
        int choice=0;
        do{
            System.out.println("\n===== Course Management =====");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Change Course Status");
            System.out.println("9. Return to Main Menu");
            System.out.println("0. Exit");

            try {
                choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1 -> {
                        Course course = new Course();
                        System.out.println("1. Adding a Course, Enter the following details...");
                        course.setCourseName(Util.isValidAlphaNumeric(readString("Course Name : "),2,20));
                        course.setDescription(Util.isValidAlphaNumeric(readString("Course Description : "),4,100));
                        course.setDurationInWeeks(readInt("Course Duration(Weeks) : "));
                        course.setActive("Y".equalsIgnoreCase(readString("Activate Course? Y/N: ")));
                        courseService.add(course);
                        System.out.println(AppMessages.SUCCESS_COURSE_ADDED);
                    }
                    case 2 -> {
                        List<Course> courses = courseService.list();
                        System.out.println("+-------+-----------------------+-------------+------------+----------+");
                        System.out.println("| ID    | Course Name           | Description |  Duration  | Status  ");
                        System.out.println("+-------+-----------------------+-------------+------------+----------+");

                        for (Course c : courses) {
                            System.out.printf("| %-5s | %-21s | %-11s |  %-10d | %-8s \n",
                                    c.getId(),
                                    c.getCourseName(),
                                    c.getDescription(),
                                    c.getDurationInWeeks(),
                                    c.isActive()?"active":"Inactive");
                        }

                        System.out.println("+-------+-----------------------+-------------+------------+----------+");

                    }
                    case 3 ->{
                        String courseId=readString("Course ID : ");
                        int status=readInt("Set to Active(1) / Inactive (2) ; Enter 1 or 2 : ");
                        if(status!=1 && status !=2) {
                            throw new InvalidInputException(AppMessages.INVALID_FIELD_VALUE);

                        }
                        else {
                            Course c = courseService.changeStatus(courseId,status==1);
                            System.out.println(AppMessages.SUCCESS_COURSE_UPDATED);
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
