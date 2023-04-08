package com.project.Accommodator.service;

import com.project.Accommodator.model.Posting;
import com.project.Accommodator.model.StudentPreferences;

import java.util.List;

/**

 The StudentPreferencesService interface provides methods for managing student preferences related to accommodation postings.
 */
public interface StudentPreferencesService {

    /**

     Creates a new student preference.
     @param studentPreferences The student preferences object to be created.
     @return The created student preferences object.
     */
    public StudentPreferences createStudentPreferences(StudentPreferences studentPreferences);
    /**

     Returns a list of accommodation postings that match the given student preferences criteria.
     @param university The university name.
     @param foodPreference The preferred food type.
     @param isSmoking The smoking preference.
     @param isDrinking The drinking preference.
     @param livingSpace The preferred living space type.
     @param studyEnvironment The preferred study environment.
     @param nationality The preferred nationality.
     @return A list of accommodation postings that match the given student preferences criteria.
     */
    public List<Posting> matchStudentPreferences(String university, String foodPreference, String isSmoking, String isDrinking, String livingSpace, String studyEnvironment, String nationality);
}