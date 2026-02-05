package com.airtribe.lts.repository;

import com.airtribe.lts.entity.Course;
import com.airtribe.lts.exception.InvalidSearchException;

import java.util.List;

public interface CourseRepo {
    /*Add new course
View all courses
Activate/Deactivate a course
     */

    Course add(Course course);
    List<Course> list();
    Course changeStatus(String courseId, boolean active) throws InvalidSearchException;
}
