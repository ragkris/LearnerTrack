package com.airtribe.lts.repository.impl;

import com.airtribe.lts.entity.Person;
import com.airtribe.lts.repository.PersonRepo;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryPersonRepoImpl <T extends Person>
        implements PersonRepo<T> {



    protected final List<T> persons = new ArrayList<>();

    @Override
    public List<T> list() {
        return new ArrayList<>(persons);
    }

    @Override
    public T view(String id) {
        return persons.stream()
                .filter(l -> l.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public T deactivate(String id) {
        T person= persons.stream()
                .filter(l -> l.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if(person!=null) person.setActive(false);
        return person;
    }
}
