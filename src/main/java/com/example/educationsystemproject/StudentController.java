package com.example.educationsystemproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/list")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }
    @GetMapping("/view/{studentID}")
    public Student findStudentByStudentID(@PathVariable Integer studentID) {
        return studentRepository.findStudentByStudentID(studentID);
    }
    @DeleteMapping("/delete/{studentID}")
    public String deleteStudentByStudentID(@PathVariable("studentID") Integer studentID) {
        studentRepository.deleteById(studentID);
        return "Student deleted from database";
    }
    @PutMapping("/modify/{studentID}")
    public Student updateStudentByStudentID(@PathVariable("studentID") Integer studentID,
                                         @RequestBody Student student) {
        Student updatedStudent;
        updatedStudent = student;
        student = studentRepository.findById(studentID)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id: "+studentID));
        student.setEmail(updatedStudent.getEmail());
        student.setAddress(updatedStudent.getAddress());
        student.setCity(updatedStudent.getCity());
        student.setPostal(updatedStudent.getPostal());
        student.setPhone(updatedStudent.getPhone());
        return studentRepository.save(student);
    }
}
