package com.project.Accommodator.token.owner;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing OwnerToken entities.
 */
public interface OwnerTokenRepository extends CrudRepository<OwnerToken, Integer> {

  /**
   * Finds all valid tokens associated with a given owner.
   *
   * @param id the owner ID to search for
   * @return a list of OwnerToken objects associated with the owner that have not expired or been revoked
   */
  @Query(value = """
      select t from OwnerToken t inner join Owner u\s
      on t.user.ownerId = u.ownerId\s
      where u.ownerId = :id and (t.expired = false or t.revoked = false)\s
      """)
  List<OwnerToken> findAllValidTokenByUser(Integer id);

  /**
   * Finds an OwnerToken object by its token string.
   *
   * @param token the token string to search for
   * @return an Optional containing the OwnerToken object, or empty if not found
   */
  Optional<OwnerToken> findByToken(String token);
}
