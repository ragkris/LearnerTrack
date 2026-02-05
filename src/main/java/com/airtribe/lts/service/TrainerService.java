package com.airtribe.lts.service;

import com.airtribe.lts.entity.Trainer;
import com.airtribe.lts.exception.InvalidSearchException;
import com.airtribe.lts.exception.LTSException;
import com.airtribe.lts.repository.TrainerRepo;
import com.airtribe.lts.repository.impl.InMemoryTrainerRepoImpl;
import com.airtribe.lts.utilities.AppMessages;

import java.util.List;

public class TrainerService {
    private final TrainerRepo repo;
    private static TrainerService instance;

    private TrainerService(TrainerRepo repo) {
        this.repo = repo;
    }


    public static TrainerService getInstance( ) {
        if (instance == null) {
            TrainerRepo trainerRepo = new InMemoryTrainerRepoImpl();
            instance = new TrainerService(trainerRepo);
        }
        return instance;
    }

    // add a new trainer
    public Trainer add(Trainer trainer) throws LTSException {
        try {
            return  this.repo.add(trainer);

        }catch (Exception e){
            throw new LTSException(AppMessages.GENERIC_ERROR);
        }
    }

    //list trainers
    public List<Trainer> list()throws LTSException {

            List<Trainer> trainers = this.repo.list();
            if (trainers.isEmpty()) {
                throw new InvalidSearchException(AppMessages.NO_TRAINER);
            }
            return trainers;
    }

    //view trainer by id
    public Trainer view(String trainerID)throws LTSException {

        Trainer t =  this.repo.view(trainerID);
        if (t== null) {
            throw new InvalidSearchException(AppMessages.INVALID_TRAINER_ID);
        }
        return t;
    }

    //deactivate trainer
    public Trainer deactivate(String trainerID)throws LTSException {

        Trainer t = this.repo.deactivate(trainerID);
        if (t== null) {
            throw new InvalidSearchException(AppMessages.INVALID_TRAINER_ID);
        }
        return t;
    }

    //view trainers by course id
    public List<Trainer> viewbyCourseID(String courseID)throws LTSException {

        List<Trainer>  trainers =  this.repo.viewTrainers(courseID);
        if (trainers == null || trainers.isEmpty()) {
            throw new InvalidSearchException(AppMessages.NO_TRAINER);
        }
        return trainers;
    }


}
