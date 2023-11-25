package com.example.educationsystemproject;

import org.springframework.data.repository.CrudRepository;

public interface GradesRepository extends CrudRepository<Grades, Integer> {
    Grades findGradesBygid(Integer gid);
    Iterable<Grades> findGradesByCourseID(Integer courseID);
    Iterable<Grades> findGradesByStudentID(Integer studentID);
}
