package com.airtribe.lts.menu;

import com.airtribe.lts.entity.Trainer;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.service.TrainerService;
import com.airtribe.lts.utilities.AppMessages;
import com.airtribe.lts.utilities.Util;

import java.util.Arrays;
import java.util.List;

public class TrainerMenu extends MenuUI{


   TrainerService trainerService = TrainerService.getInstance();

    protected  void show() {
        int choice=0;
        do{
            System.out.println("\n===== Trainer Management =====");
            System.out.println("1. Add Trainer");
            System.out.println("2. View All Trainers");
            System.out.println("3. View Trainer by ID");
            System.out.println("4. Deactivate Trainer by ID");
            System.out.println("5. View all Trainers by Course ID");
            System.out.println("9. Return to Main Menu");
            System.out.println("0. Exit");
            try {
                choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1 -> {

                        System.out.println("1. Adding a Trainer, Enter the following details...");
                        String firstname =(Util.isValidAlpha(readString("First Name : "),3,20));
                        String lastname= (Util.isValidAlpha(readString("Last Name : "),3,20));
                        String email = (Util.isValidEmail(readString("Email : ")));

                        Trainer trainer = new Trainer(firstname,lastname,email);

                        String courseIds = Util.isValidAlphaNumeric(readString("Course IDs (separated by ,) : "),2,100);
                        List<String> courses = Arrays.stream(courseIds.split("\\s*,\\s*")) .filter(s -> !s.isEmpty()) .toList();
                        String tech = Util.isValidAlphaNumeric(readString("Technologies Known (separated by ,): "),2,100);
                        List<String> techStacks = Arrays.stream(tech.split("\\s*,\\s*")).filter(s -> !s.isEmpty()).toList();
                        trainer.setCourseIds(courses);
                        trainer.setTechStack(techStacks);
                        trainer.setActive(true);
                        trainerService.add(trainer);
                        System.out.println(AppMessages.SUCCESS_TRAINER_ADDED);
                    }
                    case 2 -> {
                        List<Trainer> trainers = trainerService.list();

                        for (Trainer t : trainers) {
                            System.out.println("ID          : " + t.getId());
                            System.out.println("Name  : " + t.getDisplayName());
                            System.out.println("Email       : " + t.getEmail());
                            System.out.println("Course IDs  : " + t.getCourseIds());
                            System.out.println("Tech Stack  : " + t.getTechStack());
                            System.out.println("Status       : " + (t.isActive() ? "active" : "Inactive"));

                            System.out.println("+-------------------------------------------------------------------------------------------------------");
                        }
                    }
                    case 3 ->{
                        String trainerID=readString("Trainer ID : ");
                        Trainer t = trainerService.view(trainerID);

                        System.out.println("ID          : " + t.getId());
                        System.out.println("Name  : " + t.getDisplayName());
                        System.out.println("Email       : " + t.getEmail());
                        System.out.println("Course IDs  : " + t.getCourseIds());
                        System.out.println("Tech Stack  : " + t.getTechStack());
                        System.out.println("Status       : " + (t.isActive() ? "active" : "Inactive"));

                        System.out.println("+-------------------------------------------------------------------------------------------------------");
                    }
                    case 4 ->{
                        String trainerID=readString("Trainer ID : ");
                        Trainer t =trainerService.deactivate(trainerID);

                        System.out.println(AppMessages.SUCCESS_TRAINER_UPDATED);
                    }
                    case 5 ->{
                        String courseID=readString("Course ID : ");
                        List<Trainer> trainers = trainerService.viewbyCourseID(courseID);

                        for (Trainer t : trainers) {

                            System.out.println("ID          : " + t.getId());
                            System.out.println("Name  : " + t.getDisplayName());
                            System.out.println("Email       : " + t.getEmail());
                            System.out.println("Course IDs  : " + t.getCourseIds());
                            System.out.println("Tech Stack  : " + t.getTechStack());
                            System.out.println("Status       : " + (t.isActive() ? "active" : "Inactive"));


                            System.out.println("+-------------------------------------------------------------------------------------------------------");
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
            }catch (Exception e){
                System.out.println(AppMessages.GENERIC_ERROR);
            }
            readString("Press ENTER to continue....");
        } while (choice != 0 && choice != 9);
    }

}
