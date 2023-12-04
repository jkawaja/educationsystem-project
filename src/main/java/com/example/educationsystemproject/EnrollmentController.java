package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/enrollment", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping("/add")
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @GetMapping("/list")
    public Iterable<Enrollment> getEnrollment() {
        return enrollmentRepository.findAll();
    }
    @GetMapping("/view/{eid}")
    public Enrollment findEnrollmentByEID(@PathVariable Integer eid) {
        return enrollmentRepository.findEnrollmentByeid(eid);
    }
    @GetMapping("/view/course/{courseID}")
    public Iterable<Enrollment> findEnrollmentByCourseID(@PathVariable Integer courseID) {
        return enrollmentRepository.findEnrollmentByCourseID(courseID);
    }
    @GetMapping("/view/student/{studentID}")
    public Iterable<Enrollment> findEnrollmentByStudentID(@PathVariable Integer studentID) {
        return enrollmentRepository.findEnrollmentByStudentID(studentID);
    }
    @DeleteMapping("/delete/{eid}")
    public String deleteEnrollmentByeid(@PathVariable("eid") Integer eid) {
        enrollmentRepository.deleteById(eid);
        return "Enrollment deleted from database";
    }
    @PutMapping("/modify/{eid}")
    public Enrollment updateEnrollmentByeid(@PathVariable("eid") Integer eid,
                                    @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment;
        updatedEnrollment = enrollment;
        enrollment = enrollmentRepository.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found for this id: "+eid));
        enrollment.setCourseID(updatedEnrollment.getCourseID());
        enrollment.setStudentID(updatedEnrollment.getStudentID());
        return enrollmentRepository.save(enrollment);
    }
}
