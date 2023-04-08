/**

 An implementation of {@link LogoutHandler} that does nothing when called to perform a logout for a user.
 This implementation is used in the context of an owner user for the Accommodator project.
 When the owner user logs out, the session should be invalidated, which is handled by Spring Security's default
 {@link org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler}. This class is used
 as a placeholder for the ownerLogoutHandler bean in the OwnerApplicationConfig class.
 */
package com.project.Accommodator.config.owner;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class OwnerLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, org.springframework.security.core.Authentication authentication) {
        // No implementation needed, as the session invalidation is handled by the default Spring Security
        // SecurityContextLogoutHandler.
    }
}