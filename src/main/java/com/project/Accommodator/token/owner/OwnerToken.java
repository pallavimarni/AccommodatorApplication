package com.project.Accommodator.token.owner;

import com.project.Accommodator.model.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a token for an owner, used for authentication.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OwnerToken")
public class OwnerToken {

  /**
   * The unique identifier for the owner token.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  /**
   * The token string.
   */
  @Column(unique = true)
  public String token;

  /**
   * The type of token.
   */
  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  /**
   * Whether the token has been revoked.
   */
  public boolean revoked;

  /**
   * Whether the token has expired.
   */
  public boolean expired;

  /**
   * The owner associated with the token.
   */
  @ManyToOne
  @JoinColumn(name = "owner_Id")
  public Owner user;

  /**
   * Returns a string representation of the `OwnerToken` object.
   *
   * @return A string representation of the `OwnerToken` object.
   */
  @Override
  public String toString() {
    return "OwnerToken{" +
            "id=" + id +
            ", token='" + token + '\'' +
            ", tokenType=" + tokenType +
            ", revoked=" + revoked +
            ", expired=" + expired +
            '}';
  }

}