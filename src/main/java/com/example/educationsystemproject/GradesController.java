package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/grades", produces = MediaType.APPLICATION_JSON_VALUE)
public class GradesController {
    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping("/add")
    public Grades addGrade(@RequestBody Grades grades) {
        return gradesRepository.save(grades);
    }

    @GetMapping("/list")
    public Iterable<Grades> getGrades() {
        return gradesRepository.findAll();
    }
    @GetMapping("/view/{gid}")
    public Grades findGradesBygid(@PathVariable Integer gid) {
        return gradesRepository.findGradesBygid(gid);
    }

    @GetMapping("/view/course/{courseID}")
    public Iterable<Grades> findGradesByCourseID(@PathVariable Integer courseID) {
        return gradesRepository.findGradesByCourseID(courseID);
    }
    @GetMapping("/view/student/{studentID}")
    public Iterable<Grades> findGradesByStudentID(@PathVariable Integer studentID) {
        return gradesRepository.findGradesByStudentID(studentID);
    }
    @DeleteMapping("/delete/{gid}")
    public String deleteCourseByCourseID(@PathVariable("gid") Integer gid) {
        gradesRepository.deleteById(gid);
        return "Grade deleted from database";
    }
    @PutMapping("/modify/{gid}")
    public Grades updateGradesByGID(@PathVariable("gid") Integer gid,
                                         @RequestBody Grades grades) {
        Grades updatedGrades;
        updatedGrades = grades;
        grades = gradesRepository.findById(gid)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id: "+gid));
        grades.setGrade(updatedGrades.getGrade());
        return gradesRepository.save(grades);
    }
}
