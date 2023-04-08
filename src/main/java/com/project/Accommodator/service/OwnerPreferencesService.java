package com.project.Accommodator.service;

import com.project.Accommodator.model.OwnerPreferences;
import com.project.Accommodator.model.Student;

import java.util.List;
/**

 The OwnerPreferencesService interface defines the methods that can be performed by the service
 layer for OwnerPreferences.
 */
public interface OwnerPreferencesService {
    /**
     * Creates a new OwnerPreferences and saves it to the database.
     *
     * @param ownerPreferences The OwnerPreferences to be created and saved
     * @return The created OwnerPreferences
     */
    public OwnerPreferences createOwnerPreferences(OwnerPreferences ownerPreferences);

    /**
     * Matches students with owner preferences based on specific criteria.
     *
     * @param university The preferred university of the student
     * @param foodPreference The preferred food type of the student
     * @param isSmoking The smoking preference of the student
     * @param isDrinking The drinking preference of the student
     * @param livingSpace The preferred living space of the student
     * @param studyEnvironment The preferred study environment of the student
     * @param nationality The preferred nationality of the student
     * @return The list of students matching the given owner preferences
     */
    public List<Student> matchOwnerPreferences(String university, String foodPreference, String isSmoking, String isDrinking, String livingSpace, String studyEnvironment, String nationality);
}