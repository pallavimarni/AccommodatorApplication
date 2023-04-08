/**

 This class is responsible for handling student authentication related HTTP requests.
 The {@code StudentAuthenticationController} class contains methods to handle HTTP requests for student
 registration, student login. It also has access to the necessary dependencies including the {@code PasswordEncoder},
 {@code StudentJwtService}, {@code StudentAuthenticationService}, and {@code StudentRepository}.

 */
package com.project.Accommodator.auth.student;

import com.project.Accommodator.config.student.StudentJwtService;
import com.project.Accommodator.model.Student;
import com.project.Accommodator.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentAuthenticationController {

  /**
   * The password encoder dependency to encode passwords.
   */
  private final PasswordEncoder passwordEncoder;

  /**
   * The JSON Web Token (JWT) service for student authentication.
   */
  private final StudentJwtService jwtService;

  /**
   * The service for handling student authentication.
   */
  private final StudentAuthenticationService service;

  /**
   * The repository for the student entity.
   */
  private final StudentRepository repository;
//  @PostMapping("/create")
//  public ResponseEntity<StudentAuthenticationResponse> register(
//      @RequestBody Student request
//  ) {
//    System.out.println("hello");
//    return ResponseEntity.ok(service.register(request));
//  }
  /**
   * Handles HTTP POST requests to register a new student.
   *
   * @param request a multipart HTTP request containing student information including first name, last name, email,
   *                password, contact number, and offer letter
   * @return a HTTP response containing a {@code StudentAuthenticationResponse} object
   * @throws IOException if an input/output error occurs
   */
  @PostMapping("/create")
  public ResponseEntity<StudentAuthenticationResponse> register(MultipartHttpServletRequest request) throws IOException{
    return ResponseEntity.ok(service.register(request));
  }

  //@PostMapping("/create")
//public ResponseEntity<StudentAuthenticationResponse> register(MultipartHttpServletRequest request) throws IOException {
//  var firstName = request.getParameter("firstName");
//  var lastName = request.getParameter("lastName");
//  var email = request.getParameter("email");
//  var password = request.getParameter("password");
//  var contactNo = Long.parseLong(request.getParameter("contactNo"));
//  var offerLetter = request.getFile("offerLetter");
//
//  var user = Student.builder()
//          .firstName(firstName)
//          .lastName(lastName)
//          .email(email)
//          .contactNo(contactNo)
//          .offerLetter(offerLetter.getBytes())
//          .password(passwordEncoder.encode(password))
//          .build();
//  var savedUser = repository.save(user);
//  var jwtToken = jwtService.generateToken(user);
//  saveUserToken(savedUser, jwtToken);
//  return ResponseEntity.ok(StudentAuthenticationResponse.builder()
//          .token(jwtToken)
//          .build());
//}

  /**
   * Handles HTTP POST requests to authenticate a student.
   *
   * @param request a HTTP request containing student authentication information including email and password
   * @return a HTTP response containing a {@code StudentAuthenticationResponse} object
   */
  @PostMapping("/login")
  public ResponseEntity<StudentAuthenticationResponse> authenticate(
          @RequestBody StudentAuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
}