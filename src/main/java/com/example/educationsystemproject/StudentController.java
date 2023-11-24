package com.example.educationsystemproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public String addStudent(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam String address,
                             @RequestParam String city,
                             @RequestParam String postal,
                             @RequestParam String phone) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setAddress(address);
        student.setCity(city);
        student.setPostal(postal);
        student.setPhone(phone);
        studentRepository.save(student);
        return "Added new student to database!";
    }

    @GetMapping("/list")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }
    @GetMapping("/find/{studentID}")
    public Student findStudentByStudentID(@PathVariable Integer studentID) {
        return studentRepository.findStudentByStudentID(studentID);
    }

}
