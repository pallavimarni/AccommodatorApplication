/**

 The OwnerAuthenticationService class provides methods to register and authenticate an owner.
 It saves user data to the repository, generates a JWT token for the user, and saves the token to the token repository.
 It also revokes all the valid tokens for a user when a new token is generated.
 */
package com.project.Accommodator.auth.owner;
import com.project.Accommodator.config.owner.OwnerJwtService;
import com.project.Accommodator.model.Owner;
import com.project.Accommodator.repository.OwnerRepository;
import com.project.Accommodator.token.owner.OwnerToken;
import com.project.Accommodator.token.owner.OwnerTokenRepository;
import com.project.Accommodator.token.owner.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerAuthenticationService {

  private final OwnerRepository repository;
  private final OwnerTokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final OwnerJwtService jwtService;

  @Autowired
  @Qualifier("ownerAuthenticationManager")
  private AuthenticationManager authenticationManager;

  /**

   Registers a new owner by saving user data to the repository, generating a JWT token for the user, and saving the token to the token repository.
   @param request the Owner object containing user data to be registered.
   @return OwnerAuthenticationResponse containing the generated JWT token and owner information.
   */
  public OwnerAuthenticationResponse register(Owner request) {
    var user = Owner.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .contactNo(request.getContactNo())
            .ownerType(request.getOwnerType())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);
    OwnerDto ownerDto = new OwnerDto(savedUser.getOwnerId(), savedUser.getEmail(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getContactNo(), savedUser.getOwnerType());
    return OwnerAuthenticationResponse.builder()
            .token(jwtToken)
            .owner(ownerDto)
            .build();
  }
  /**

   Authenticates an owner by verifying the user credentials, generating a new JWT token, and revoking all the valid tokens for the user.
   @param request the OwnerAuthenticationRequest object containing the user credentials to be authenticated.
   @return OwnerAuthenticationResponse containing the generated JWT token and owner information.
   */
  public OwnerAuthenticationResponse authenticate(OwnerAuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var user = repository.findByEmail(request.getEmail())
            .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    OwnerDto ownerDto = new OwnerDto(user.getOwnerId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getContactNo(), user.getOwnerType());
    return OwnerAuthenticationResponse.builder()
            .token(jwtToken)
            .owner(ownerDto)
            .build();
  }
  /**

   Saves the user token to the token repository.
   @param user the Owner object representing the user.
   @param jwtToken the JWT token generated for the user.
   */
  private void saveUserToken(Owner user, String jwtToken) {
    var token = OwnerToken.builder()
            .user(user)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();
        tokenRepository.save(token);
  }
  /**
   * Revokes all valid tokens associated with the given owner user by setting them as expired and revoked in the token repository.
   *
   * @param user the owner user whose tokens are to be revoked
   */
  private void revokeAllUserTokens(Owner user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getOwnerId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
