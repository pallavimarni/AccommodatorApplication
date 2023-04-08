package com.project.Accommodator.service;
import com.project.Accommodator.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * The StudentService interface provides methods to create, retrieve and manage students.
 */
public interface StudentService {
    /**
     * Retrieve a student with the given id
     *
     * @param id The id of the student to retrieve
     * @return The retrieved student
     */
    Student getStudentById(int id);

    //    Student loginStudent(String email,String password);
    /**
     * Login a student with the given email and password
     *
     * @param email The email of the student to login
     * @param password The password of the student to login
     * @return An optional student if the email and password match, otherwise null
     */
    Optional<Student> loginStudent(String email, String password);
    /**
     * Retrieve all students
     *
     * @return The list of all students
     */
    Iterable<Student> getAllStudents();

    /**
     * Create a new student
     *
     * @param Student The student to create
     * @return The created student
     */
    Student createStudent(Student Student);

    /**
     * Create a new student with the given information
     *
     * @param firstName The first name of the student to create
     * @param lastName The last name of the student to create
     * @param email The email of the student to create
     * @param password The password of the student to create
     * @param contactNo The contact number of the student to create
     * @param pdfFile The PDF file containing the student's offer letter
     * @throws IOException If there is an error reading the PDF file
     */
    void createStudent(String firstName, String lastName, String email, String password, Long contactNo, MultipartFile pdfFile) throws IOException;
}