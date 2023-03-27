package com.project.Accommodator.service;
import com.project.Accommodator.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService {

    Student getStudentById(int id);
    Student loginStudent(String email,String password);
    Iterable<Student> getAllStudents();
    Student createStudent(String firstName, String lastName, String email, String password, Long contactNo, MultipartFile pdfFile) throws IOException;
}
