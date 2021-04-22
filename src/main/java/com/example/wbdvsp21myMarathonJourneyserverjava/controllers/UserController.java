package com.example.wbdvsp21myMarathonJourneyserverjava.controllers;

import com.example.wbdvsp21myMarathonJourneyserverjava.models.User;
import com.example.wbdvsp21myMarathonJourneyserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "https://my-marathon-journey.herokuapp.com",
        allowCredentials = "true")
public class UserController {
  @Autowired
  UserService service;

  @GetMapping("/")
  public String testServer() {
    return "Hi. Server is running!";
  }

  @PostMapping("/api/users")
  public User createUser(
          @RequestBody User user
  ) {
    return service.createUser(user);
  }

  @GetMapping("/api/users")
  public List<User> findAllUsers() {
    return service.findAllUsers();
  }

  @GetMapping("/api/users/{uid}")
  public User findUserById(
          @PathVariable("uid") Long id
  ) {
    return service.findUserById(id);
  }


  @DeleteMapping("/api/users/{uid}")
  public Integer deleteUser(
          @PathVariable("uid") Long id) {
    return service.deleteUser(id);
  }

  @PutMapping("/api/users/{uid}")
  public Integer updateUser(
          @PathVariable("uid") Long id,
          @RequestBody User user) {
    return service.updateUser(id, user);
  }
}

