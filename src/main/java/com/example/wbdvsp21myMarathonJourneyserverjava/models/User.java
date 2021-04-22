package com.example.wbdvsp21myMarathonJourneyserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  private String userName;
  private String password;
  private String role;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String userBiography;
  private String emailAddress;

  public User(Long id, String userName, String password, String firstName,
              String lastName, String dateOfBirth, String role, String emailAddress) {
    this.userId = id;
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.password = password;
    this.role = role;
    this.userBiography = "";
    this.emailAddress = emailAddress;

  }

  public User() {
  }
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long id) {
    this.userId = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName (String userName) {
    this.userName = userName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getUserBiography() {
    return userBiography;
  }

  public void setUserBiography(String userBiography) {
    this.userBiography = userBiography;
  }
}
