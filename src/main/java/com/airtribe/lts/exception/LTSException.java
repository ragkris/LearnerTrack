package com.airtribe.lts.exception;

public class LTSException extends Exception{

    public LTSException (String errormessage){
        super(errormessage);
    }
    public LTSException (Exception e){
        super(e);
    }
}
