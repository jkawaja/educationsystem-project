package com.example.educationsystemproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public String addCourse(@RequestParam String courseName,
                             @RequestParam String courseNumber,
                             @RequestParam String capacity) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        courseRepository.save(course);
        return "Added new course to database!";
    }

    @GetMapping("/list")
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }
    @GetMapping("/find/{courseID}")
    public Course findCourseByCourseID(@PathVariable Integer courseID) {
        return courseRepository.findCourseByCourseID(courseID);
    }
}
