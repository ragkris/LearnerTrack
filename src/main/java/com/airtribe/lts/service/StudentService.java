package com.airtribe.lts.service;

import com.airtribe.lts.entity.Student;
import com.airtribe.lts.exception.InvalidSearchException;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.repository.StudentRepo;
import com.airtribe.lts.repository.impl.InMemoryStudentRepoImpl;
import com.airtribe.lts.utilities.AppMessages;

import java.util.List;

public class StudentService {
    private final  StudentRepo repo;
    private static StudentService instance;

    private StudentService(StudentRepo repo) {
        this.repo = repo;
    }


    public static StudentService getInstance( ) {
        if (instance == null) {
            StudentRepo studentRepo = new InMemoryStudentRepoImpl();
            instance = new StudentService(studentRepo);
        }
        return instance;
    }

    // add a new student
    public Student add(Student student) throws LTSException {
        try {
            return  this.repo.add(student);

        }catch (Exception e){
            throw new LTSException(AppMessages.GENERIC_ERROR);
        }
    }
    //list of students
    public List<Student> list()throws LTSException {
        List<Student>  students = this.repo.list();
        if (students == null || students.isEmpty()) {
            throw new InvalidSearchException(AppMessages.NO_STUDENTS);
        }
        return students;
    }

    //view student by id
    public Student view(String studentID)throws LTSException {

        Student s = this.repo.view(studentID);

        if (s==null) {
            throw new InvalidSearchException(AppMessages.INVALID_STUDENT_ID);

        }
        return s;
    }

    //deactivate student
    public Student deactivate(String studentID)throws LTSException {

        Student s =  this.repo.deactivate(studentID);
        if (s==null) {
            throw new InvalidSearchException(AppMessages.INVALID_STUDENT_ID);

        }
        return s;
    }
}
