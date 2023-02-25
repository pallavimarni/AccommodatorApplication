package com.project.Accommodator.model;

import jakarta.persistence.*;

@Entity
@Table(name="Posting")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String rent;
    private String address;
    private String description;
    private String date;
    private String category;
    private String image;
    private Integer ownerId;

    public Posting() {
    }

    public Posting(Integer postId, String rent, String address, String description, String date, String category, String image, Integer ownerId) {
        this.postId = postId;
        this.rent = rent;
        this.address = address;
        this.description = description;
        this.date = date;
        this.category = category;
        this.image = image;
        this.ownerId = ownerId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
