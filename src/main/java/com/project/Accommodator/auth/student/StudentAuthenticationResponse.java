/**

 Represents the response data sent back to the client upon successful authentication of a student user.
 */
package com.project.Accommodator.auth.student;
import com.project.Accommodator.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAuthenticationResponse {

  /**

   The JWT token generated for the authenticated student user.
   */
  private String token;
  /**

   Information about the authenticated student user in the form of a StudentDto object.
   */
  private StudentDto student;
}