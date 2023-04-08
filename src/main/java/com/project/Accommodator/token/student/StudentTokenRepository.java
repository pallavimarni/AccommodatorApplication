package com.project.Accommodator.token.student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**

 This interface extends the CrudRepository for the StudentToken model and defines custom methods for the StudentToken repository.
 */
public interface StudentTokenRepository extends CrudRepository<StudentToken, Integer> {
  /**

   Returns a list of all valid StudentTokens for the given user ID, where the token is not expired or revoked.
   @param id the ID of the user whose tokens to retrieve
   @return a List of StudentToken objects for the user with the given ID
   */
  List<StudentToken> findAllValidTokenByUser(Integer id);
  /**

   Returns an Optional containing the StudentToken with the given token string, or an empty Optional if no such token exists.
   @param token the token string to search for
   @return an Optional containing the StudentToken object with the given token string, or an empty Optional if no such token exists
   */
  Optional<StudentToken> findByToken(String token);
}