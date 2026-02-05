package com.airtribe.lts.repository;

import com.airtribe.lts.entity.Trainer;

import java.util.List;

public interface TrainerRepo extends PersonRepo<Trainer> {

      /*
Add new trainer
View all trainers
Search trainer by ID
view trainer by course id
Deactivate a trainer (set active = false instead of deleting)
*/

    List<Trainer> viewTrainers(String courseId);

}
