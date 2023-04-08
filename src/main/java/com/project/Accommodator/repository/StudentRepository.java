package com.project.Accommodator.repository;

import com.project.Accommodator.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**

 Repository interface for performing CRUD operations on Student entities.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {

    /**

     Retrieves a student by their email, password, and approval status.
     @param email the email of the student
     @param password the password of the student
     @return the student entity if found, otherwise null
     */
    @Query("SELECT s FROM Student s WHERE s.email = ?1 and s.password = ?2 and s.isApproved = 1")
    Student findByEmail(String email,String password);
    /**

     Retrieves a student by their email.
     @param email the email of the student
     @return an Optional containing the student entity if found, otherwise empty
     */
    Optional<Student> findByEmail(String email);
    /**

     Retrieves all students who have not been approved or revoked.
     @return an Iterable of Student entities
     */
    @Query("SELECT s FROM Student s WHERE s.isApproved = 0 and s.isRevoked = 0")
    Iterable<Student> getAllStudents();
}