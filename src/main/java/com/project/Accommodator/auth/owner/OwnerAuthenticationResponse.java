/**

 A class representing the response returned by the OwnerAuthenticationController upon successful authentication.
 */
package com.project.Accommodator.auth.owner;
import com.project.Accommodator.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerAuthenticationResponse {

  /**

   The token generated upon successful authentication.
   */
  private String token;
  /**

   The owner object containing details of the authenticated owner.
   */
  private OwnerDto owner;
}



