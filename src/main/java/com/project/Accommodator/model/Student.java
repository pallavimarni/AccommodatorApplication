package com.project.Accommodator.model;

import jakarta.persistence.*;
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String firstName;
    private String lastName;
    private String offerLetter;
    private String email;
    private String password;
    private int isApproved;
    private int contactNo;

    public Student() {
    }

    public Student(int studentId, String firstName, String lastName, String offerLetter, String email, String password, int isApproved, int contactNo) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.offerLetter = offerLetter;
        this.email = email;
        this.password = password;
        this.isApproved = isApproved;
        this.contactNo = contactNo;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getOfferLetter() {
        return offerLetter;
    }

    public void setOfferLetter(String offerLetter) {
        this.offerLetter = offerLetter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }
}
