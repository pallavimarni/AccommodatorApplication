package com.project.Accommodator.model;

import com.project.Accommodator.token.student.StudentToken;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;


/**

 This class represents a Student entity in the application.

 It implements the UserDetails interface, which provides details about a user
 */
@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class Student implements UserDetails {

    /**

     The unique identifier of the student.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    /**

     The first name of the student.
     */
    private String firstName;
    /**

     The last name of the student.
     */
    private String lastName;
    /**

     The offer letter of the student, as a byte array.
     */
    private byte[] offerLetter;
    /**

     The email address of the student.
     */
    private String email;
    /**

     The password of the student's account.
     */
    private String password;
    /**

     Whether the student's account has been approved or not.
     */
    private int isApproved;
    /**

     The contact number of the student.
     */
    private Long contactNo;
    /**

     Whether the student's account has been revoked or not.
     */
    private int isRevoked;
    /**

     The list of tokens associated with the student's account.
     */
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<StudentToken> tokens;

//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Favorite> favorites;

    public Student() {
    }
    // This constructor initializes all fields of the student
    public Student(int studentId, String firstName, String lastName, byte[] offerLetter, String email, String password, int isApproved, Long contactNo, int isRevoked) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.offerLetter = offerLetter;
        this.email = email;
        this.password = password;
        this.isApproved = isApproved;
        this.contactNo = contactNo;
        this.isRevoked = isRevoked;
    }
    /**

     Returns a string representation of the student.
     @return the string representation of the student.
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isApproved=" + isApproved +
                ", contactNo=" + contactNo +
                ", isRevoked=" + isRevoked +
                '}';
    }
    /**

     Returns the unique identifier of the student.
     @return the unique identifier of the student.
     */

    public int getStudentId() {
        return studentId;
    }
    /**

     Sets the unique identifier of the student.
     @param studentId the unique identifier of the student.
     */

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    /**

     Returns the first name of the student.
     @return the first name of the student.
     */

    public String getFirstName() {
        return firstName;
    }
    /**

     Sets the first name of the student.
     @param firstName the first name of the student.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**

     Returns the last name of the student.
     @return the last name of the student.
     */

    public String getLastName() {
        return lastName;
    }
    /**

     Sets the last name of the student.
     @param lastName the last name of the student.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**

     Returns the offer letter of the student, as a byte array.
     @return the offer letter of the student, as a byte array.
     */

    public byte[] getOfferLetter() {
        return offerLetter;
    }
    /**

     Sets the offer letter of the student, as a byte array.
     @param offerLetter the offer letter of the student, as a byte array.
     */

    public void setOfferLetter(byte[] offerLetter) {
        this.offerLetter = offerLetter;
    }
    /**

     Returns the email address of the student.
     @return the email address of the student.
     */

    public String getEmail() {
        return email;
    }
    /**

     Sets the email address of the student.
     @param email the email address of the student.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**

     Returns a collection of authorities granted to the user.
     In this case, only the "ROLE_STUDENT" authority is granted.
     @return the collection of authorities granted to the user
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_STUDENT"));
    }
    /**

     Returns the password used to authenticate the user.
     @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }
    /**

     Returns the email used to authenticate the user.
     @return the email
     */
    @Override
    public String getUsername() {
        return email;
    }
    /**

     Indicates whether the user's account has expired.
     @return true if the user's account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**

     Indicates whether the user is locked or unlocked.
     @return true if the user is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**

     Indicates whether the user's credentials (password) has expired.
     @return true if the user's credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**

     Indicates whether the user is enabled or disabled.
     @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    /**

     Sets the password of the user.
     @param password the new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**

     Returns whether the student's account is approved or not.
     @return 1 if the account is approved, 0 otherwise
     */
    public int getIsApproved() {
        return isApproved;
    }
    /**

     Sets whether the student's account has been approved or not.
     @param isApproved whether the student's account has been approved or not.
     */

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }
    /**

     Returns the contact number of the student.
     @return the contact number of the student.
     */

    public long getContactNo() {
        return contactNo;
    }
    /**

     Sets the contact number of the student.
     @param contactNo the contact number of the student.
     */

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

}
