package com.airtribe.lts.entity;

public enum EnrolmentStatus {

    ACTIVE("active"),
    COMPLETED("completed"),
    CANCELLED("cancelled");


    private final String value;

    EnrolmentStatus(String value) {

        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
