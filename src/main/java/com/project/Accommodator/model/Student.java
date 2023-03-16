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
    private byte[] offerLetter;
    private String email;
    private String password;
    private int isApproved;
    private Long contactNo;
    private int isRevoked;

    public Student() {
    }

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

    public byte[] getOfferLetter() {
        return offerLetter;
    }

    public void setOfferLetter(byte[] offerLetter) {
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

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public int getIsRevoked() {
        return isRevoked;
    }

    public void setIsRevoked(int isRevoked) {
        this.isRevoked = isRevoked;
    }
}
