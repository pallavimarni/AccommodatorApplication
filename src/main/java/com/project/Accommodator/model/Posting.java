package com.project.Accommodator.model;

import java.util.Set;
import jakarta.persistence.*;

/**
 This class represents a posting object which contains details about a rental posting.
 The Posting class is annotated with @Entity and @Table to specify that it is a persistent entity
 and is mapped to a database table named "Posting".
 The class contains private fields postId, rent, address, description, date, category, image,
 type, pincode, email, ownerId, which are the attributes of a posting.
 The class has constructors for creating a Posting object, a no-args constructor and a constructor
 with arguments to set the fields of the object.
 The class has getter and setter methods for all fields, which allow other classes to access and
 modify the fields of the Posting object.
 */

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Posting")
public class Posting {

    /**

     The ID of the posting.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    /**

     The rent amount for the posting.
     */
    private String rent;
    /**

     The address of the posting.
     */
    private String address;
    /**

     The description of the posting.
     */
    private String description;
    /**

     The date the posting was created.
     */
    private String date;
    /**

     The category of the posting (e.g. apartment, house, room).
     */
    private String category;
    /**

     The URL of the image for the posting.
     */
    private String image;
    /**

     The type of posting (e.g. for rent, sublet, lease).
     */
    private String type;
    /**

     The pincode of the posting.
     */
    private String pincode;
    /**

     The email of the poster.
     */
    private String email;
    /**

     The ID of the user who posted the posting.
     */
    private Integer ownerId;
//    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Favorite> favorites;
    /**
     * Constructs an empty Posting object.
     */
    public Posting() {
    }

    /**
     * Constructs a Posting object with the specified postId.
     *
     * @param postId the ID of the posting
     */
    public Posting(Integer postId) {
        this.postId = postId;
    }

    /**
     * Constructs a Posting object with the specified attributes.
     *
     * @param postId the ID of the posting
     * @param rent the rent amount for the posting
     * @param address the address of the posting
     * @param description the description of the posting
     * @param date the date the posting was created
     * @param category the category of the posting
     * @param image the URL of the image for the posting
     * @param type the type of posting
     * @param pincode the pincode of the posting
     * @param email the email of the poster
     * @param ownerId the ID of the user who posted the posting
     */
    public Posting(Integer postId, String rent, String address, String description, String date, String category, String image, String type, String pincode, String email, Integer ownerId) {
        this.postId = postId;
        this.rent = rent;
        this.address = address;
        this.description = description;
        this.date = date;
        this.category = category;
        this.image = image;
        this.type = type;
        this.pincode = pincode;
        this.email = email;
        this.ownerId = ownerId;
    }

    /**

     The unique identifier of this posting.
     @return The unique identifier of this posting.
     */
    public Integer getPostId() {
        return postId;
    }
    /**

     Sets the unique identifier of this posting.
     @param postId The unique identifier of this posting.
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    /**

     The rent amount of this posting.
     @return The rent amount of this posting.
     */
    public String getRent() {
        return rent;
    }
    /**

     Sets the rent amount of this posting.
     @param rent The rent amount of this posting.
     */
    public void setRent(String rent) {
        this.rent = rent;
    }
    /**

     The address of this posting.
     @return The address of this posting.
     */
    public String getAddress() {
        return address;
    }
    /**

     Sets the address of this posting.
     @param address The address of this posting.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**

     The description of this posting.
     @return The description of this posting.
     */
    public String getDescription() {
        return description;
    }
    /**

     Sets the description of this posting.
     @param description The description of this posting.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**

     The date of this posting.
     @return The date of this posting.
     */
    public String getDate() {
        return date;
    }
    /**

     Sets the date of this posting.
     @param date The date of this posting.
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**

     The category of this posting.
     @return The category of this posting.
     */
    public String getCategory() {
        return category;
    }
    /**

     Sets the category of this posting.
     @param category The category of this posting.
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**

     The image of this posting.
     @return The image of this posting.
     */
    public String getImage() {
        return image;
    }
    /**

     Sets the image of this posting.
     @param image The image of this posting.
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**

     The type of this posting.
     @return The type of this posting.
     */
    public String getType() {
        return type;
    }
    /**

     Sets the type of this posting.
     @param type The type of this posting.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**

     The pincode of this posting.
     @return The pincode of this posting.
     */
    public String getPincode() {
        return pincode;
    }
    /**

     Sets the pincode of this posting.
     @param pincode The pincode of this posting.
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    /**

    The email of the owner of this posting.
    @return The email
    */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the owner of this posting.
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }
    /**

     The ID of the user who posted this posting.
     @return The ID of the user who posted this posting.
     */

    public Integer getOwnerId() {
        return ownerId;
    }
    /**

     Sets the ID of the user who posted this posting.
     @param ownerId The ID of the user who posted this posting.
     */

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
