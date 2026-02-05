package com.airtribe.lts.menu;

import java.util.Scanner;

public class MenuUI {

    private final Scanner scanner = new Scanner(System.in);



    public void start() {
        int choice;

        StudentMenu studentMenu = new StudentMenu();
        TrainerMenu trainerMenu = new TrainerMenu();
        CourseMenu courseMenu = new CourseMenu();
        EnrolmentMenu enrolmentMenu = new EnrolmentMenu();

        System.out.println("\n===== Learner Tracking System =====");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrolment Management");
        System.out.println("4. Trainer Management");
        System.out.println("0. Exit");

        choice = readInt("Enter your choice: ");

        switch (choice) {
            case 1 ->studentMenu.show();
            case 2 -> courseMenu.show();
            case 3 -> enrolmentMenu.show();
            case 4 -> trainerMenu.show();
            case 0 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice. Please try again.");
        }

    }









    protected   int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    protected  String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }








}
