package com.airtribe.lts.repository;

import com.airtribe.lts.entity.Person;

import java.util.List;

public interface PersonRepo<T extends Person> {

    T add(T person);
    List<T> list();
     T view(String id);
     T deactivate(String id);





}
