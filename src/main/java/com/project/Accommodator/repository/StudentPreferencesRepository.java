package com.project.Accommodator.repository;

import com.project.Accommodator.model.Posting;
import com.project.Accommodator.model.StudentPreferences;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**

 This interface extends the CrudRepository and represents the repository for StudentPreferences entity. It provides a method to query

 for matching postings based on the given university, food preference, smoking preference, drinking preference, living space preference,

 study environment preference, and nationality.
 */

public interface StudentPreferencesRepository extends CrudRepository<StudentPreferences, Integer> {

    /**

     This method uses a JPQL query to find matching postings based on the given university, food preference, smoking preference, drinking preference,
     living space preference, study environment preference, and nationality.
     @param university the university preference of the student
     @param foodPreference the food preference of the student
     @param isSmoking the smoking preference of the student
     @param isDrinking the drinking preference of the student
     @param livingSpace the living space preference of the student
     @param studyEnvironment the study environment preference of the student
     @param nationality the nationality preference of the student
     @return a List of Posting objects that match the given preferences
     */
    @Query("SELECT p FROM OwnerPreferences o INNER JOIN Posting p ON p.ownerId = o.ownerId\n" +
            "WHERE CASE WHEN o.university = ?1 THEN 1 ELSE 0 END +\n" +
            " CASE WHEN o.food = ?2 THEN 1 ELSE 0 END +\n" +
            " CASE WHEN o.smokingPref = ?3 THEN 1 ELSE 0 END +\n" +
            " CASE WHEN o.drinkingPref = ?4 THEN 1 ELSE 0 END +\n" +
            " CASE WHEN o.livingPref = ?5 THEN 1 ELSE 0 END +\n" +
            " CASE WHEN o.studyPref = ?6 THEN 1 ELSE 0 END +\n" +
            " CASE WHEN o.nationality = ?7 THEN 1 ELSE 0 END > 2\n")
    List<Posting> matchStudentPreferences(String university, String foodPreference, String isSmoking, String isDrinking, String livingSpace, String studyEnvironment, String nationality);
}