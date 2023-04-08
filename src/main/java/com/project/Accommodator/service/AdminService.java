package com.project.Accommodator.service;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
/**

 The AdminService interface defines the methods for performing administrative operations such as approving or rejecting a student.
 */
public interface AdminService {
     /**
      * Approves a student with the given id.
      *
      * @param id The id of the student to be approved.
      */
     void approveStudentById(@PathVariable("id") int id);

     /**
      * Rejects a student with the given id.
      *
      * @param id The id of the student to be rejected.
      */
     void rejectStudentById(@PathVariable("id") int id);
}
