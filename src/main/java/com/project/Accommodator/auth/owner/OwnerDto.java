/**

 A Data Transfer Object class representing an Owner entity for authentication purposes.
 It contains fields for ownerId, email, firstName, lastName, contactNo, and ownerType.
 */
package com.project.Accommodator.auth.owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    private Integer ownerId;
    private String email;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String ownerType;
}





