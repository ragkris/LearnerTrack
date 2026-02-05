package com.airtribe.lts.entity;

public class Student extends Person {

    private String batch;

    public Student(String firstName, String lastName,String email) {
        super(firstName, lastName,email);
    }

    public Student(String firstName, String lastName, String email, String batch) {

        super(firstName, lastName,email);
        this.batch=batch;
    }

    @Override
    public String getDisplayName() {
        return super.getDisplayName() + " (" + batch + ")";
    }

    public String getBatch() {
        return batch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "batch='" + batch + '\'' +
                "} " + super.toString();
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

}
