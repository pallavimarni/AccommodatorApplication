/**

 A class representing the authentication request made by a student user.
 */
package com.project.Accommodator.auth.student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAuthenticationRequest {

  /**

   The email of the student user making the authentication request.
   */
  private String email;
  /**

   The password of the student user making the authentication request.
   */
  private String password;
}