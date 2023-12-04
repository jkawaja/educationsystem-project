package com.example.educationsystemproject;

import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
    Enrollment findEnrollmentByeid(Integer eid);
    Iterable<Enrollment> findEnrollmentByCourseID(Integer courseID);
    Iterable<Enrollment> findEnrollmentByStudentID(Integer studentID);

}
