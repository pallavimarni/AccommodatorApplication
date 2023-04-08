package com.project.Accommodator.repository;

import com.project.Accommodator.model.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**

 Repository interface for the Admin entity, extends the CrudRepository interface.
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    /**

     Approves a student by setting the isApproved field to true.
     @param id The ID of the student to be approved.
     */
    @Modifying
    @Query(value = "UPDATE Student s SET isApproved = 1 WHERE s.studentId = ?1",nativeQuery = true)
    void approveStudentById(int id);
    /**

     Rejects a student by setting the isRevoked field to true.
     @param id The ID of the student to be rejected.
     */
    @Modifying
    @Query(value = "UPDATE Student s SET isRevoked = 1 WHERE s.studentId = ?1",nativeQuery = true)
    void rejectStudentById(int id);
}