package com.project.Accommodator.config;

import com.project.Accommodator.config.owner.OwnerJwtService;
import com.project.Accommodator.config.student.StudentJwtService;
import com.project.Accommodator.token.owner.OwnerTokenRepository;
import com.project.Accommodator.token.student.StudentTokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * This filter intercepts incoming requests and checks whether the request contains a valid JWT token in the
 * "Authorization" header. If the token is valid, the filter sets the authentication context of the current request.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final StudentJwtService studentJwtService;
    private final OwnerJwtService ownerJwtService;

    @Autowired
    private UserDetailsService studentUserDetailsService;

    @Autowired
    private UserDetailsService ownerUserDetailsService;

    private final StudentTokenRepository studentTokenRepository;
    private final OwnerTokenRepository ownerTokenRepository;

    /**
     * Filters incoming requests to check for valid JWT tokens in the "Authorization" header. If a valid JWT token
     * is found, the authentication context of the request is set.
     *
     * @param request The incoming HTTP servlet request.
     * @param response The outgoing HTTP servlet response.
     * @param filterChain The filter chain to continue processing the request.
     * @throws ServletException if there is a servlet error.
     * @throws IOException if there is an I/O error.
     */
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        // Get the "Authorization" header from the incoming request.
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        // Check if the header is null or does not start with "Bearer ".
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // If the header is invalid, continue processing the request.
            filterChain.doFilter(request, response);
            return;
        }
        // Extract the JWT token from the header.
        jwt = authHeader.substring(7);
        // Extract the user email from the JWT token.
        userEmail = studentJwtService.extractUsername(jwt);
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        // Check if the user email is not null and there is no existing authentication context for the request.
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails;
            boolean isTokenValid;
            // Check if the JWT token is associated with a student or owner user account.
            if (studentTokenRepository.findByToken(jwt).isPresent()) {
                // If the token is associated with a student account, retrieve the user details for the account.
                userDetails = studentUserDetailsService.loadUserByUsername(userEmail);
                // Check if the token is valid (not expired or revoked).
                isTokenValid = studentTokenRepository.findByToken(jwt)
                        .map(t -> !t.isExpired() && !t.isRevoked())
                        .orElse(false);
            } else {
                // If the token is associated with an owner account, retrieve the user details for the account.
                userDetails = ownerUserDetailsService.loadUserByUsername(userEmail);
                // Check if the token is valid (not expired or revoked).
                isTokenValid = ownerTokenRepository.findByToken(jwt)
                        .map(t -> !t.isExpired() && !t.isRevoked())
                        .orElse(false);
            }
            // If the token is valid and associated with a user account, set the authentication context for the request.
            if ((studentJwtService.isTokenValid(jwt, userDetails) || ownerJwtService.isTokenValid(jwt, userDetails)) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        filterChain.doFilter(request, response);
    }
}
