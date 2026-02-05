package com.airtribe.lts.repository.impl;

import com.airtribe.lts.entity.Student;
import com.airtribe.lts.repository.StudentRepo;
import com.airtribe.lts.utilities.IDGenerator;

public class InMemoryStudentRepoImpl extends InMemoryPersonRepoImpl<Student> implements StudentRepo {


    @Override
    public Student add(Student learner) {
        learner.setId(IDGenerator.genrateID(IDGenerator.ENTITY_TYPE.STUDENT));
        persons.add(learner);

        return learner;
    }
}
