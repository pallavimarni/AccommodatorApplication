package com.project.Accommodator.token.student;

import com.project.Accommodator.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**

 This class represents the authentication token for a student user.
 It contains the token itself, its type, and the user it belongs to.
 It also has fields to track if the token is revoked or expired.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StudentToken")
public class StudentToken {
  /**

   The ID of the token.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  /**

   The actual token string.
   */
  @Column(unique = true)
  public String token;
  /**

   The type of the token.
   */
  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;
  /**

   Whether or not the token has been revoked.
   */
  public boolean revoked;
  /**

   Whether or not the token has expired.
   */
  public boolean expired;
  /**

   The student user that this token belongs to.
   */
  @ManyToOne
  @JoinColumn(name = "student_Id")
  public Student user;
  /**

   Returns a string representation of the StudentToken object.
   */
  @Override
  public String toString() {
    return "StudentToken{" +
            "id=" + id +
            ", token='" + token + '\'' +
    ", tokenType=" + tokenType +
            ", revoked=" + revoked +
            ", expired=" + expired +
            '}';
  }
}