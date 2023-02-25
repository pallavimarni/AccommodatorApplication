package com.project.Accommodator.repository;

import com.project.Accommodator.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
