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
    public String addCourse(@RequestParam Integer studentID,
                            @RequestParam Integer courseID,
                            @RequestParam String grade) {
        Grades grades = new Grades();
        grades.setStudentID(studentID);
        grades.setCourseID(courseID);
        grades.setGrade(grade);
        gradesRepository.save(grades);
        return "Added new course to database!";
    }

    @GetMapping("/list")
    public Iterable<Grades> getGrades() {
        return gradesRepository.findAll();
    }
    @GetMapping("/find/{gid}")
    public Grades findGradesByGID(@PathVariable Integer gid) {
        return gradesRepository.findGradesByGID(gid);
    }
    @DeleteMapping("/find/{gid}")
    public void deleteCourseByCourseID(@PathVariable("gid") Integer gid) {
        gradesRepository.deleteById(gid);
    }
    @PutMapping("/find/{gid}")
    public String updateGradesByGID(@PathVariable("gid") Integer gid,
                                         @RequestParam String grade) {
        Grades grades = gradesRepository.findById(gid)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id: "+gid));
        grades.setGrade(grade);
        gradesRepository.save(grades);
        return "Updated grade!";
    }
}
