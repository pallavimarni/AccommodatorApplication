package com.project.Accommodator.repository;

import com.project.Accommodator.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1 and s.password = ?2")
    public Student findByEmail(String email,String password);
}
