package com.airtribe.lts.repository.impl;

import com.airtribe.lts.entity.Trainer;
import com.airtribe.lts.repository.TrainerRepo;
import com.airtribe.lts.utilities.IDGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTrainerRepoImpl extends InMemoryPersonRepoImpl<Trainer> implements TrainerRepo {

    @Override
    public Trainer add(Trainer trainer) {
        trainer.setId(IDGenerator.genrateID(IDGenerator.ENTITY_TYPE.TRAINER));
        persons.add(trainer);

        return trainer;
    }

    @Override
    public List<Trainer> viewTrainers(String courseId) {

        return persons.stream()
                .filter(t -> t.getCourseIds() != null
                        && t.getCourseIds().contains(courseId))
                .collect    (Collectors.toList());
    }
}
