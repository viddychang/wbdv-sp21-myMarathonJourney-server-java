package com.example.wbdvsp21myMarathonJourneyserverjava.controllers;

import com.example.wbdvsp21myMarathonJourneyserverjava.models.User;
import com.example.wbdvsp21myMarathonJourneyserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//https://my-marathon-journey.herokuapp.com
//http://localhost:3000
@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "https://my-marathon-journey.herokuapp.com"},
        allowCredentials = "true")
public class UserSessionController {
  @Autowired
  UserService service;

  @PostMapping("/api/users/register")
  public User register(@RequestBody User user,
                       HttpSession session) {
    session.setAttribute("profile", user);
    User newUser = service.createUser(user);
    return newUser;
  }

  @GetMapping("/api/users/profile")
  public User profile(HttpSession session) {
    return (User) session.getAttribute("profile");
  }

  @PostMapping("/api/session/logout")
  public String invalidateSession(
          HttpSession session) {
    session.invalidate();
    return "Session has been invalidated";
  }

  @PostMapping("/api/users/login")
  public User login(
          @RequestBody User credentials, HttpSession session) {
    User existingUser = service.findUserByCredentials(credentials.getUserName(),
            credentials.getPassword());
    if (existingUser != null) {
      session.setAttribute("profile", existingUser);
      return existingUser;
    } return null;
  }

  @GetMapping("/api/session/set/{attr}/{value}")
  public String setSessionAttribute(
          @PathVariable("attr") String attr,
          @PathVariable("value") String value,
          HttpSession session) {
    session.setAttribute(attr, value);
    return attr + " = " + value;
  }

  @GetMapping("/api/session/get/{attr}")
  public String getSessionAttribute(
          @PathVariable("attr") String attr,
          HttpSession session) {
    return (String) session.getAttribute(attr);
  }
}
