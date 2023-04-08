package com.project.Accommodator.service.implementation;

import com.project.Accommodator.model.Student;
import com.project.Accommodator.service.StudentService;
import com.project.Accommodator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


/**

 The StudentServiceImplementation class implements the StudentService interface and provides methods

 to perform CRUD operations on Student entities.
 */
@Service
public class StudentServiceImplementation implements StudentService {

    /**

     Repository for performing Student operations.
     */
    @Autowired
    StudentRepository StudentRepository;
    /**

     Default constructor.
     */
    public StudentServiceImplementation() {
        super();
    }
    /**

     Retrieves a Student object with the given id.
     @param id The id of the student to retrieve.
     @return The Student object with the given id.
     */
    @Override
    public Student getStudentById(int id) {
        Student student = StudentRepository.findById(id).orElse(null);
        return student;
    }
    /**

     Retrieves all Student objects.
     @return An Iterable collection of all Student objects.
     */
    @Override
    public Iterable<Student> getAllStudents() {
        Iterable<Student> students = StudentRepository.getAllStudents();
        return students;
    }
    /**

     Creates a new Student object.
     @param student The Student object to create.
     @return The newly created Student object.
     */
    @Override
    public Student createStudent(Student student) {
        return StudentRepository.save(student);
    }
    /**

     Creates a new Student object with the given parameters.
     @param firstName The first name of the student.
     @param lastName The last name of the student.
     @param email The email address of the student.
     @param password The password of the student.
     @param contactNo The contact number of the student.
     @param pdfFile The offer letter of the student.
     @throws IOException If an I/O error occurs while reading the offer letter file.
     */
    @Override
    public void createStudent(String firstName, String lastName, String email, String password, Long contactNo, MultipartFile pdfFile) throws IOException {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPassword(password);
        student.setContactNo(contactNo);
        student.setOfferLetter(pdfFile.getBytes());
        StudentRepository.save(student);
    }
    /**

     Logs in a student with the given email and password.
     @param email The email address of the student.
     @param password The password of the student.
     @return An Optional object containing the logged in Student object if login is successful, otherwise empty.
     */
    @Override
    public Optional<Student> loginStudent(String email, String password) {
        Optional<Student> stu = StudentRepository.findByEmail(email);
        if (stu == null) {
            try {
                throw new Exception("Student not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return stu;
        }
    }
}