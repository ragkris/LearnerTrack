package com.airtribe.lts.utilities;

public class IDGenerator {
    private static  long STUDENT_COUNTER=1;
    private static  long TRAINER_COUNTER=1;
    private static  long COURSE_COUNTER=1;
    private static  long ENROLMENT_COUNTER=1;

    public enum ENTITY_TYPE {

        STUDENT,
        TRAINER,
        COURSE,
        ENROLMENT
    }

    // Generate ID for each entity
        public static String genrateID(ENTITY_TYPE type){
        StringBuilder id=new StringBuilder();
        switch (type){
            case STUDENT -> {
                id.append("LR_").append(String.format("%05d",STUDENT_COUNTER++));
            }
            case TRAINER -> {
                id.append("TR_").append(String.format("%03d",TRAINER_COUNTER++));
            }
            case COURSE -> {
                id.append("C_").append(String.format("%03d",COURSE_COUNTER++));
            }
            case ENROLMENT -> {
                id.append("EN_").append(String.format("%05d",ENROLMENT_COUNTER++));
            }
        }
        return id.toString();
        }

}
