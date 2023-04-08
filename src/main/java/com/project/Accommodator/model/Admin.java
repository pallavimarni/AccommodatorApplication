package com.project.Accommodator.model;

import jakarta.persistence.*;

/**

 The Admin class represents an admin user of the Accommodator system.
 */
@Entity
@Table(name="Admin")
public class Admin {

    /**

     The email of the admin.
     */
    @Id
    private String email;
    /**

     The password of the admin.
     */
    private String password;
    /**

     Default constructor for the Admin class.
     */
    public Admin() {
    }
    /**

     Constructor for the Admin class.
     @param email the email of the admin
     @param password the password of the admin
     */
    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }
    /**

     Gets the email of the admin.
     @return the email of the admin
     */
    public String getEmail() {
        return email;
    }
    /**

     Sets the email of the admin.
     @param email the email of the admin
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**

     Gets the password of the admin.
     @return the password of the admin
     */
    public String getPassword() {
        return password;
    }
    /**

     Sets the password of the admin.
     @param password the password of the admin
     */
    public void setPassword(String password) {
        this.password = password;
    }
}