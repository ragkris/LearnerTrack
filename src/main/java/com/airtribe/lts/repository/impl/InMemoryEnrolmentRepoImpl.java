package com.airtribe.lts.repository.impl;

import com.airtribe.lts.entity.Enrolment;
import com.airtribe.lts.entity.EnrolmentStatus;
import com.airtribe.lts.repository.EnrolmentRepo;
import com.airtribe.lts.utilities.IDGenerator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryEnrolmentRepoImpl implements EnrolmentRepo {

    protected final Map<String, Enrolment> enrolmentMap= new HashMap<>();

    @Override
    public Enrolment enroll(String studentId, String courseId) {

        Enrolment enroll = new Enrolment(studentId,courseId, new Date());
        enroll.setId(IDGenerator.genrateID(IDGenerator.ENTITY_TYPE.ENROLMENT));
        enroll.setStatus(EnrolmentStatus.ACTIVE);
        enrolmentMap.put(enroll.getId(), enroll);
        return enroll;
    }

    @Override
    public List<Enrolment> viewEnrolment(String studentId) {

        return enrolmentMap.values().stream()
                .filter(l -> l.getStudentId().equalsIgnoreCase(studentId))
                .collect    (Collectors.toList());


    }

    @Override
    public Enrolment changeEnrolmentStatus(String enrolmentId, EnrolmentStatus status) {
        Enrolment enrolment= enrolmentMap.get(enrolmentId);
        if(enrolment!=null) enrolment.setStatus(status);
        return enrolment;
    }
}
