package com.project.Accommodator.repository;

import com.project.Accommodator.model.Posting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**

 Interface for accessing and manipulating the Posting entities from the database.
 */
public interface PostingRepository extends CrudRepository<Posting, Integer> {

    /**

     Returns a list of all the postings created by an owner with a specific ID.
     @param id the ID of the owner
     @return a list of postings created by the owner with the specified ID
     */
    @Query("SELECT p FROM Posting p WHERE p.ownerId = ?1")
    List<Posting> getPostingById(int id);
}


