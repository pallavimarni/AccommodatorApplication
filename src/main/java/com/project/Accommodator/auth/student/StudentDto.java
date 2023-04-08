/**

 Data Transfer Object (DTO) class for Student entity, used to transfer Student data between layers of the application.
 */
package com.project.Accommodator.auth.student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {
    /**
     * Unique identifier for a student.
     */
    private int id;
    /**
     * First name of the student.
     */
    private String firstName;

    /**
     * Last name of the student.
     */
    private String lastName;

    /**
     * Email address of the student.
     */
    private String email;

    /**
     * Contact number of the student.
     */
    private Long contactNo;
}