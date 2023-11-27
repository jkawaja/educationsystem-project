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
    @GetMapping("/view/{courseID}")
    public Course findCourseByCourseID(@PathVariable Integer courseID) {
        return courseRepository.findCourseByCourseID(courseID);
    }
    @DeleteMapping("/delete/{courseID}")
    public void deleteCourseByCourseID(@PathVariable("courseID") Integer courseID) {
        courseRepository.deleteById(courseID);
    }
    @PutMapping("/modify/{courseID}")
    public String updateCourseByCourseID(@PathVariable("courseID") Integer courseID,
                            @RequestParam String courseName,
                            @RequestParam String courseNumber,
                            @RequestParam String capacity) {
        Course course = courseRepository.findById(courseID)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id: "+courseID));
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        courseRepository.save(course);
        return "Updated course!";
    }
}
