package com.airtribe.lts.service;

import com.airtribe.lts.entity.Course;
import com.airtribe.lts.entity.Enrolment;
import com.airtribe.lts.entity.EnrolmentStatus;
import com.airtribe.lts.entity.Student;
import com.airtribe.lts.exception.InvalidInputException;
import com.airtribe.lts.exception.InvalidSearchException;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.repository.EnrolmentRepo;
import com.airtribe.lts.repository.impl.InMemoryEnrolmentRepoImpl;
import com.airtribe.lts.utilities.AppMessages;

import java.util.List;

public class EnrolmentService {
    private final EnrolmentRepo repo;
    private static EnrolmentService instance;
    StudentService studentService = StudentService.getInstance();
    CourseService courseService = CourseService.getInstance();

    private EnrolmentService(EnrolmentRepo repo) {
        this.repo = repo;
    }


    public static EnrolmentService getInstance( ) {
        if (instance == null) {
            EnrolmentRepo enrolmentRepo = new InMemoryEnrolmentRepoImpl();
            instance = new EnrolmentService(enrolmentRepo);
        }
        return instance;
    }

    //enroll a student to a course
    public Enrolment enroll(String studentId, String courseId) throws LTSException {
        try {
                // validate if course and student exists
                Student s = studentService.view(studentId);
                Course c =  courseService.list().stream().filter(c1->c1.getId().equalsIgnoreCase(courseId)).findFirst().orElse(null);
                if(s==null) throw new InvalidInputException(AppMessages.INVALID_STUDENT_ID);
                if(c==null) throw new InvalidInputException(AppMessages.INVALID_COURSE_ID);


            return  this.repo.enroll(studentId,courseId);

        }catch (LTSException e){
            throw e;
        }
    }

    // view enrolment by student id
    public List<Enrolment> view(String studentId)throws LTSException {

        List<Enrolment> enrolments = this.repo.viewEnrolment(studentId);
        if (enrolments.isEmpty()) {
            throw new InvalidSearchException(AppMessages.NO_ENROLMENTS);
        }
        return  enrolments;
    }

    //toggle enrolment status
    public Enrolment changeStatus(String enrolId, EnrolmentStatus status)throws LTSException {

        Enrolment en= this.repo.changeEnrolmentStatus(enrolId, status);
        if (en == null) {
            throw new InvalidInputException(AppMessages.INVALID_ENROLMENT_ID);
        }
       return en;
    }

}
