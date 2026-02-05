package com.airtribe.lts.entity;

import java.util.Date;

public class Enrolment {

    private String id;
    private String studentId;
    private String courseId;
    private Date enrollmentDate;
    private EnrolmentStatus status;



    public Enrolment(String studentId, String courseId, Date enrollmentDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrolmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrolmentStatus status) {
        this.status = status;
    }
}
