package com.airtribe.lts.service;

import com.airtribe.lts.entity.Course;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.repository.CourseRepo;
import com.airtribe.lts.repository.impl.InMemoryCourseRepoImpl;
import com.airtribe.lts.utilities.AppMessages;

import java.util.List;

public class CourseService {

    private final CourseRepo repo;
    private static CourseService instance;

    private CourseService(CourseRepo repo) {
        this.repo = repo;
    }


    public static CourseService getInstance( ) {
        if (instance == null) {
            CourseRepo courseRepo = new InMemoryCourseRepoImpl();
            instance = new CourseService(courseRepo);
        }
        return instance;
    }

    //To add a new course
    public Course add(Course course) throws LTSException {
       try {
           return  this.repo.add(course);
       }catch (Exception e){
           throw new LTSException(AppMessages.GENERIC_ERROR);
       }
    }

    //list courses
    public List<Course> list()throws LTSException {
        List<Course> courses =  this.repo.list();
        if (courses.isEmpty()) {
            throw new LTSException(AppMessages.NO_COURSES);
        }
       return courses;
    }

    //toggle course status
    public Course changeStatus(String courseId, boolean active)throws LTSException {

        Course c = this.repo.changeStatus(courseId, active);
        if (c==null) {
            throw new LTSException(AppMessages.INVALID_COURSE_ID);
        }
        return c;

    }
}
