package com.airtribe.lts.utilities;

import com.airtribe.lts.exception.InvalidInputException;

public class Util {

    private static final String NAME_REGEX = "^[A-Za-z]+$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final String ALPHANUMERIC_REGEX = "^[A-Za-z0-9, ]+$";
    private static final String ID_VALIDATOR_REGEX= "^[A-Za-z0-9_]+$";

    //check only alpha
    public static String isValidAlpha(String name, int min, int max)  throws InvalidInputException{

        String trimmed= (name==null)?null:name.trim();
        if (trimmed != null && !trimmed.isEmpty()) {
            if(trimmed.length() >= min &&  trimmed.length() <= max &&   trimmed.matches(NAME_REGEX))
                return  trimmed;

        }
        throw new InvalidInputException(AppMessages.INVALID_FIELD_VALUE);


    }

    //check alphanumeric, space , and ,
    public static String isValidAlphaNumeric(String desc, int min, int max) throws InvalidInputException{
        String trimmed= (desc==null)?null:desc.trim();
        if (trimmed != null && !trimmed.isEmpty()) {
            if(trimmed.length() >= min &&  trimmed.length() <= max &&   trimmed.matches(ALPHANUMERIC_REGEX))
                return  trimmed;

        }
        throw new InvalidInputException(AppMessages.INVALID_FIELD_VALUE);
    }
    //validate id format alphanumeric with _
    public static String isValidIDFormat(String id) throws InvalidInputException{
        String trimmed= (id==null)?null:id.trim();
        if (trimmed != null && !trimmed.isEmpty()) {
            if(trimmed.matches(ID_VALIDATOR_REGEX))
                return  trimmed;

        }
        throw new InvalidInputException(AppMessages.INVALID_FIELD_VALUE);
    }

    //validate email format
    public static String isValidEmail(String email) throws  InvalidInputException{
        String trimmed= (email==null)?null:email.trim();

       if( trimmed != null && trimmed.length() <= 254 && trimmed.matches(EMAIL_REGEX)){
           return trimmed;
        }
        throw new InvalidInputException(AppMessages.INVALID_EMAIL);
    }

}
