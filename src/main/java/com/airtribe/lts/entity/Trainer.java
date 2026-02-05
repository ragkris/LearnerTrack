package com.airtribe.lts.entity;

import java.util.List;

public class Trainer extends  Person{


    private List<String> techStack;
    private List<String> courseIds;

    public Trainer(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "techStack=" + techStack +
                ", courseIds=" + courseIds +
                "} " + super.toString();
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    public List<String> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<String> courseIds) {
        this.courseIds = courseIds;
    }
}
