package com.project.Accommodator.model;

import jakarta.persistence.*;

@Entity
@Table(name="Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;
    private String email;
    private String firstName;
    private String lastName;
    private Long contactNo;
    private String ownerType;
    private String password;

    public Owner() {
    }

    public Owner(Integer ownerId, String email, String firstName, String lastName, Long contactNo, String ownerType, String password) {
        this.ownerId = ownerId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.ownerType = ownerType;
        this.password = password;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}