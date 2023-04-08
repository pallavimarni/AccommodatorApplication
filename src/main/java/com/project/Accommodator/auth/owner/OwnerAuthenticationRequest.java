/**
  The OwnerAuthenticationRequest class represents the request object for owner authentication.
 It contains the owner's email and password.
 */
package com.project.Accommodator.auth.owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerAuthenticationRequest {

  /**

   The email of the owner.
   */
  private String email;
  /**

   The password of the owner.
   */
  private String password;
}