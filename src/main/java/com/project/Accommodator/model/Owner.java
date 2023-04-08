package com.project.Accommodator.model;

import com.project.Accommodator.token.owner.OwnerToken;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * The Owner class represents an owner entity that implements UserDetails.
 * It is used to store information about a particular owner of a property.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Owner")
public class Owner implements UserDetails {

    /**
     * The unique identifier for the owner.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;

    /**
     * The email address of the owner.
     */
    private String email;

    /**
     * The first name of the owner.
     */
    private String firstName;

    /**
     * The last name of the owner.
     */
    private String lastName;

    /**
     * The contact number of the owner.
     */
    private String contactNo;

    /**
     * The type of owner, e.g. individual, company, etc.
     */
    private String ownerType;

    /**
     * The password of the owner.
     */
    private String password;

    /**
     * The list of owner tokens.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<OwnerToken> tokens;

    /**
     * Constructor with ownerId, email, firstName, lastName, contactNo, ownerType, and password parameters.
     *
     * @param ownerId   The unique identifier for the owner.
     * @param email     The email address of the owner.
     * @param firstName The first name of the owner.
     * @param lastName  The last name of the owner.
     * @param contactNo The contact number of the owner.
     * @param ownerType The type of owner, e.g. individual, company, etc.
     * @param password  The password of the owner.
     */
    public Owner(Integer ownerId, String email, String firstName, String lastName, String contactNo, String ownerType, String password) {
        this.ownerId = ownerId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.ownerType = ownerType;
        this.password = password;
    }

    /**
     * Constructor with id parameter.
     *
     * @param id The unique identifier for the owner.
     */
    public Owner(int id) {
        this.ownerId = id;
    }

    /**
     * Returns a string representation of the Owner object.
     *
     * @return A string representation of the Owner object.
     */
    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", ownerType='" + ownerType + '\'' +
                '}';
    }

    /**
     * Returns the unique identifier for the owner.
     *
     * @return The unique identifier for the owner.
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the unique identifier for the owner.
     *
     * @param ownerId The unique identifier for the owner.
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Returns the email address of the owner.
     *
     * @return The email address of the owner.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the owner.
     *
     * @param email The email address of the owner.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the first name of the owner.
     *
     * @return The first name of the owner.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the owner.
     *
     * @param firstName The first name of the owner.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the owner.
     *
     * @return The last name of the owner.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the owner.
     *
     * @param lastName The last name of the owner.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the contact number of the owner.
     *
     * @return The contact number of the owner.
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * Sets the contact number of the owner.
     *
     * @param contactNo The contact number of the owner.
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * Returns the type of owner.
     *
     * @return The type of owner.
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * Sets the type of owner.
     *
     * @param ownerType The type of owner.
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }


    /**
     * Returns the authorities granted to the user. This method is not used in this project, so it always returns null.
     *
     * @return the authorities granted to the user
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password used to authenticate the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user. In this case, it returns the email address of the owner.
     *
     * @return the username used to authenticate the user
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the user's account has expired. This method always returns true as account expiration is not implemented in this project.
     *
     * @return always returns true as account expiration is not implemented in this project.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. This method always returns true as user locking is not implemented in this project.
     *
     * @return always returns true as user locking is not implemented in this project.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. This method always returns true as password expiration is not implemented in this project.
     *
     * @return always returns true as password expiration is not implemented in this project.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. This method always returns true as user disabling is not implemented in this project.
     *
     * @return always returns true as user disabling is not implemented in this project.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Sets the password of the owner.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}