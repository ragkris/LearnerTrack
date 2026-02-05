package com.airtribe.lts.repository;

import com.airtribe.lts.entity.Enrolment;
import com.airtribe.lts.entity.EnrolmentStatus;

import java.util.List;

public interface EnrolmentRepo {

 /*   Enroll a student in a course
    View enrollments for a student
    Mark enrollment as completed/cancelled
*/

  Enrolment enroll(String studentId, String courseId);
  List<Enrolment> viewEnrolment(String studentId);
  Enrolment changeEnrolmentStatus(String enrolmentId, EnrolmentStatus status);


}
