package com.example.wbdvsp21myMarathonJourneyserverjava.controllers;

import com.example.wbdvsp21myMarathonJourneyserverjava.models.User;
import com.example.wbdvsp21myMarathonJourneyserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.websocket.server.PathParam;

//https://my-marathon-journey.herokuapp.com
//http://localhost:3000
@RestController
@CrossOrigin(origins = {"http://localhost:3000",
        "http://my-marathon-journey.herokuapp.com"},
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


  @GetMapping("/api/users/username")
  public List<User> findUsersByUserName(
          @RequestParam("name") String userName) {
    return service.findUserListByUserName(userName);
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

