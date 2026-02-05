package com.airtribe.lts.repository.impl;

import com.airtribe.lts.entity.Course;
import com.airtribe.lts.exception.InvalidSearchException;
import com.airtribe.lts.repository.CourseRepo;
import com.airtribe.lts.utilities.IDGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCourseRepoImpl implements CourseRepo {

    protected final Map<String, Course> courses= new HashMap<>();

    @Override
    public Course add(Course course) {
        course.setId(IDGenerator.genrateID(IDGenerator.ENTITY_TYPE.COURSE));
        courses.put(course.getId(), course);

        return course;
    }

    @Override
    public List<Course> list() {
        return new ArrayList<>(courses.values());
    }


    @Override
    public Course changeStatus(String id, boolean active) throws InvalidSearchException {
        Course course= courses.get(id);
        if(course!=null) course.setActive(active);
        return course;
    }

}
