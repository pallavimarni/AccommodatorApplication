package com.project.Accommodator.model;
import jakarta.persistence.*;

/**

 An entity representing owner preferences for a rental property.

 This class maps to a database table named "OwnerPreferences".
 */
@Entity
@Table(name = "OwnerPreferences")
public class OwnerPreferences {

    /**
     * The unique identifier for an owner preferences object.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerPreferencesId;
    /**
     * The university that the owner prefers for their tenant(s).
     */
    private String university;
    /**
     * The nationality that the owner prefers for their tenant(s).
     */
    private String nationality;
    /**
     * The food preference that the owner has for their tenant(s).
     */
    private String food;
    /**
     * The smoking preference that the owner has for their tenant(s).
     */
    private String smokingPref;
    /**
     * The drinking preference that the owner has for their tenant(s).
     */
    private String drinkingPref;
    /**
     * The living preference that the owner has for their tenant(s).
     */
    private String livingPref;
    /**
     * The study preference that the owner has for their tenant(s).
     */
    private String studyPref;
    /**
     * The unique identifier of the owner who has these preferences.
     */
    private int ownerId;

    /**
     * Creates an empty owner preferences object.
     */
    public OwnerPreferences() {
    }

    /**
     * Creates an owner preferences object with the given parameter values.
     *
     * @param ownerPreferencesId The unique identifier for the owner preferences object.
     * @param university         The university that the owner prefers for their tenant(s).
     * @param nationality        The nationality that the owner prefers for their tenant(s).
     * @param food               The food preference that the owner has for their tenant(s).
     * @param smokingPref        The smoking preference that the owner has for their tenant(s).
     * @param drinkingPref       The drinking preference that the owner has for their tenant(s).
     * @param livingPref         The living preference that the owner has for their tenant(s).
     * @param studyPref          The study preference that the owner has for their tenant(s).
     * @param ownerId            The unique identifier of the owner who has these preferences.
     */
    public OwnerPreferences(int ownerPreferencesId, String university, String nationality, String food,
                            String smokingPref, String drinkingPref, String livingPref, String studyPref, int ownerId) {
        this.ownerPreferencesId = ownerPreferencesId;
        this.university = university;
        this.nationality = nationality;
        this.food = food;
        this.smokingPref = smokingPref;
        this.drinkingPref = drinkingPref;
        this.livingPref = livingPref;
        this.studyPref = studyPref;
        this.ownerId = ownerId;
    }

    /**
     * Creates an owner preferences object with only the ownerPreferencesId parameter value set.
     *
     * @param id The unique identifier for the owner preferences object.
     */
    public OwnerPreferences(int id) {
        this.ownerPreferencesId = id;
    }

    /**
     * Gets the unique identifier for this owner preferences object.
     *
     * @return The unique identifier for this owner preferences object.
     */
    public int getOwnerPreferencesId() {
        return ownerPreferencesId;
    }

    /**
     * Sets the unique identifier for this owner preferences object.
     *
     * @param ownerPreferencesId The unique identifier to set for this owner preferences object.
     */
    public void setOwnerPreferencesId(int ownerPreferencesId) {
        this.ownerPreferencesId = ownerPreferencesId;
    }

    /**
     * Returns the university preference of the owner.
     *
     * @return the university preference of the owner.
     */
    public String getUniversity() {
        return university;
    }

    /**
     * Sets the university preference of the owner.
     *
     * @param university the university preference of the owner.
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * Returns the nationality preference of the owner.
     *
     * @return the nationality preference of the owner.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality preference of the owner.
     *
     * @param nationality the nationality preference of the owner.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Returns the food preference of the owner.
     *
     * @return the food preference of the owner.
     */
    public String getFood() {
        return food;
    }

    /**
     * Sets the food preference of the owner.
     *
     * @param food the food preference of the owner.
     */
    public void setFood(String food) {
        this.food = food;
    }

    /**
     * Returns the smoking preference of the owner.
     *
     * @return the smoking preference of the owner.
     */
    public String getSmokingPref() {
        return smokingPref;
    }

    /**
     * Sets the smoking preference of the owner.
     *
     * @param smokingPref the smoking preference of the owner.
     */
    public void setSmokingPref(String smokingPref) {
        this.smokingPref = smokingPref;
    }

    /**
     * Returns the drinking preference of the owner.
     *
     * @return the drinking preference of the owner.
     */
    public String getDrinkingPref() {
        return drinkingPref;
    }

    /**
     * Sets the drinking preference of the owner.
     *
     * @param drinkingPref the drinking preference of the owner.
     */
    public void setDrinkingPref(String drinkingPref) {
        this.drinkingPref = drinkingPref;
    }

    /**
     * Returns the living preference of the owner.
     *
     * @return the living preference of the owner.
     */
    public String getLivingPref() {
        return livingPref;
    }

    /**
     * Sets the living preference of the owner.
     *
     * @param livingPref the living preference of the owner.
     */
    public void setLivingPref(String livingPref) {
        this.livingPref = livingPref;
    }

    /**
     * Returns the study preference of the owner.
     *
     * @return the study preference of the owner.
     */
    public String getStudyPref() {
        return studyPref;
    }

    /**
     * Sets the study preference of the owner.
     *
     * @param studyPref the study preference of the owner.
     */
    public void setStudyPref(String studyPref) {
        this.studyPref = studyPref;
    }

    /**
     * Returns the ID of the owner.
     *
     * @return the ID of the owner.
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the ID of the owner.
     *
     * @param ownerId the ID of the owner.
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}