package com.project.Accommodator.model;
import jakarta.persistence.*;
/**

 Entity class representing the StudentPreferences table in the database.
 */
@Entity
@Table(name = "StudentPreferences")
public class StudentPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentPreferencesId;
    private String university;
    private String nationality;
    private String food;
    private String smokingPref;
    private String drinkingPref;
    private String livingPref;
    private String studyPref;
    private String interests;
    private int studentId;

    /**

     Default constructor for the StudentPreferences class.
     */
    public StudentPreferences() {
    }
    /**

     Constructor for the StudentPreferences class.
     @param studentPreferencesId the unique identifier for the student preferences.
     @param university the preferred university of the student.
     @param nationality the preferred nationality of the student.
     @param food the preferred food of the student.
     @param smokingPref the smoking preference of the student.
     @param drinkingPref the drinking preference of the student.
     @param livingPref the preferred living conditions of the student.
     @param studyPref the preferred study environment of the student.
     @param interests the interests of the student.
     @param studentId the ID of the student associated with these preferences.
     */
    public StudentPreferences(int studentPreferencesId, String university, String nationality, String food, String smokingPref, String drinkingPref, String livingPref, String studyPref, String interests, int studentId) {
        this.studentPreferencesId = studentPreferencesId;
        this.university = university;
        this.nationality = nationality;
        this.food = food;
        this.smokingPref = smokingPref;
        this.drinkingPref = drinkingPref;
        this.livingPref = livingPref;
        this.studyPref = studyPref;
        this.interests = interests;
        this.studentId = studentId;
    }
    /**

     Constructor for the StudentPreferences class.
     @param id the unique identifier for the student preferences.
     */
    public StudentPreferences(int id) {
        this.studentPreferencesId = id;
    }

    /**
     * Returns the unique identifier for the student preferences.
     * @return
     */

    public int getStudentPreferencesId() {
        return studentPreferencesId;
    }
    /**

     Sets the unique identifier for the student preferences.
     @param studentPreferencesId the unique identifier for the student preferences.
     */

    public void setStudentPreferencesId(int studentPreferencesId) {
        this.studentPreferencesId = studentPreferencesId;
    }
    /**

     Returns the preferred university of the student.
     @return the preferred university of the student.
     */

    public String getUniversity() {
        return university;
    }
    /**

     Sets the preferred university of the student.
     @param university the preferred university of the student.
     */

    public void setUniversity(String university) {
        this.university = university;
    }


    /**

     Returns the nationality preference of the student.
     @return the nationality preference of the student
     */
    public String getNationality() {
        return nationality;
    }
    /**

     Sets the nationality preference of the student.
     @param nationality the nationality preference of the student
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    /**

     Returns the food preference of the student.
     @return the food preference of the student
     */
    public String getFood() {
        return food;
    }
    /**

     Sets the food preference of the student.
     @param food the food preference of the student
     */
    public void setFood(String food) {
        this.food = food;
    }
    /**

     Returns the smoking preference of the student.
     @return the smoking preference of the student
     */
    public String getSmokingPref() {
        return smokingPref;
    }
    /**

     Sets the smoking preference of the student.
     @param smokingPref the smoking preference of the student
     */
    public void setSmokingPref(String smokingPref) {
        this.smokingPref = smokingPref;
    }
    /**

    Returns the drinking preference of the student.
    @return the drinking preference of the student
    */

    public String getDrinkingPref() {
        return drinkingPref;
    }
    /**

     Sets the drinking preference of the student.
     @param drinkingPref the drinking preference of the student
     */

    public void setDrinkingPref(String drinkingPref) {
        this.drinkingPref = drinkingPref;
    }
    /**

     Returns the living preference of the student.
     @return the living preference of the student
     */

    public String getLivingPref() {
        return livingPref;
    }
    /**

     Sets the living preference of the student.
     @param livingPref the living preference of the student
     */

    public void setLivingPref(String livingPref) {
        this.livingPref = livingPref;
    }
    /**

     Returns the study preference of the student.
     @return the study preference of the student
     */

    public String getStudyPref() {
        return studyPref;
    }
    /**

     Sets the study preference of the student.
     @param studyPref the study preference of the student
     */

    public void setStudyPref(String studyPref) {
        this.studyPref = studyPref;
    }
    /**

     Returns the interests of the student.
     @return the interests of the student
     */

    public String getInterests() {
        return interests;
    }
    /**

     Sets the interests of the student.
     @param interests the interests of the student
     */

    public void setInterests(String interests) {
        this.interests = interests;
    }
    /**

     Returns the ID of the student associated with these preferences.
     @return the ID of the student associated with these preferences
     */

    public int getStudentId() {
        return studentId;
    }
    /**

     Sets the ID of the student associated with these preferences.
     @param studentId the ID of the student associated with these preferences
     */

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
