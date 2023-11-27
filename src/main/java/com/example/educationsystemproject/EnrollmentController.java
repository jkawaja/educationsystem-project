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
    public String addEnrollment(@RequestParam Integer studentID,
                           @RequestParam Integer courseID) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentID(studentID);
        enrollment.setCourseID(courseID);
        enrollmentRepository.save(enrollment);
        return "Added new enrollment to database!";
    }

    @GetMapping("/list")
    public Iterable<Enrollment> getEnrollment() {
        return enrollmentRepository.findAll();
    }
    @GetMapping("/list/{eid}")
    public Enrollment findEnrollmentByEID(@PathVariable Integer eid) {
        return enrollmentRepository.findEnrollmentByeid(eid);
    }
    @GetMapping("/list/course/{courseID}")
    public Iterable<Enrollment> findEnrollmentByCourseID(@PathVariable Integer courseID) {
        return enrollmentRepository.findEnrollmentByCourseID(courseID);
    }
    @GetMapping("/list/student/{studentID}")
    public Iterable<Enrollment> findEnrollmentByStudentID(@PathVariable Integer studentID) {
        return enrollmentRepository.findEnrollmentByStudentID(studentID);
    }
    @DeleteMapping("/delete/{eid}")
    public String deleteEnrollmentByeid(@PathVariable("eid") Integer eid) {
        enrollmentRepository.deleteById(eid);
        return "Enrollment deleted from database";
    }
    @PutMapping("/modify/{eid}")
    public String updateEnrollmentByeid(@PathVariable("eid") Integer eid,
                                    @RequestParam Integer courseID,
                                    @RequestParam Integer studentID) {
        Enrollment enrollment = enrollmentRepository.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found for this id: "+eid));
        enrollment.setCourseID(courseID);
        enrollment.setStudentID(studentID);
        enrollmentRepository.save(enrollment);
        return "Updated Enrollment!";
    }
}
