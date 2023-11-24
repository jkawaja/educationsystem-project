package com.example.educationsystemproject;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findStudentByStudentID(Integer id);
}
