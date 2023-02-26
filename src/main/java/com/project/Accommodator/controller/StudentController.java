package com.project.Accommodator.controller;
import com.project.Accommodator.model.Student;
import com.project.Accommodator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @CrossOrigin
    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }
    @CrossOrigin
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student Student) {
        return studentService.createStudent(Student);
    }

    @CrossOrigin
    @PostMapping("/login")
    public Student loginStudent(@RequestParam String email, String password) {
        return studentService.loginStudent(email,password);
    }

}
