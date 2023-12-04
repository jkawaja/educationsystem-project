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
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
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
    public String deleteCourseByCourseID(@PathVariable("courseID") Integer courseID) {
        courseRepository.deleteById(courseID);
        return "Course deleted from database";
    }
    @PutMapping("/modify/{courseID}")
    public Course updateCourseByCourseID(@PathVariable("courseID") Integer courseID,
                            @RequestBody Course course) {
        Course updatedCourse;
        updatedCourse = course;
        course = courseRepository.findById(courseID)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id: "+courseID));
        course.setCapacity(updatedCourse.getCapacity());
        course.setYear(updatedCourse.getYear());
        course.setSemester(updatedCourse.getSemester());
        course.setPid(updatedCourse.getPid());
        return courseRepository.save(course);
    }
}
