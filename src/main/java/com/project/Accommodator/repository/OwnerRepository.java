package com.project.Accommodator.repository;

import com.project.Accommodator.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**

 This interface defines database operations for Owner entities.
 */
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    /**

     Finds an Owner entity by its email.
     @param email The email to search for.
     @return An Optional containing the Owner entity if found, otherwise empty.
     */
    Optional<Owner> findByEmail(String email);
}