package com.project.Accommodator.service;
import com.project.Accommodator.model.Owner;

/**

 This interface provides methods to perform CRUD operations on Owner entities.
 */
public interface OwnerService {

    /**

     Creates a new Owner entity.
     @param owner The Owner object to be created.
     @return The created Owner object.
     */
    Owner createOwner(Owner owner);
    /**

     Retrieves an Owner entity by its ID.
     @param id The ID of the Owner entity to retrieve.
     @return The Owner object with the specified ID, or null if no Owner was found.
     */
    Owner getOwnerById(int id);
}