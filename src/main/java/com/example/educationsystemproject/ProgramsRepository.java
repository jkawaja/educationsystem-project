package com.example.educationsystemproject;

import org.springframework.data.repository.CrudRepository;



public interface ProgramsRepository extends CrudRepository<Programs, Integer> {
    Programs findProgramsBypid(Integer pid);
}
