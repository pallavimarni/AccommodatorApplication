package com.project.Accommodator.service;
import com.project.Accommodator.model.Student;

public interface StudentService {
    Student createStudent(Student Student);

    Student getStudentById(int id);

}
