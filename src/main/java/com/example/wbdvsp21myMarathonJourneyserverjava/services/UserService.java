package com.example.wbdvsp21myMarathonJourneyserverjava.services;

import com.example.wbdvsp21myMarathonJourneyserverjava.models.User;
import com.example.wbdvsp21myMarathonJourneyserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  UserRepository repository;

  public User createUser(User user) {
    return repository.save(user);
  }

  public List<User> findAllUsers() {
    return (List<User>) repository.findAll();
  }

  public User findUserById(Long userId) {
    return repository.findUserById(userId);
  }

  public Integer deleteUser(Long id) {
    repository.deleteById(id);
    return 1;
  }

  public Integer updateUser(Long id, User user) {
    if (repository.findById(id).isPresent()) {
      User actualUser = repository.findById(id).get();

      if (user.getUserId() != null) {
        actualUser.setUserId(user.getUserId());
      }
      if (user.getEmailAddress() != null) {
        actualUser.setEmailAddress(user.getEmailAddress());
      }
      if (user.getFirstName() != null) {
        actualUser.setFirstName(user.getFirstName());
      }
      if (user.getLastName() != null) {
        actualUser.setLastName(user.getLastName());
      }
      if (user.getPassword() != null) {
        actualUser.setPassword(user.getPassword());
      }
      if (user.getRole() != null) {
        actualUser.setRole(user.getRole());
      }
      if (user.getDateOfBirth() != null) {
        actualUser.setDateOfBirth(user.getDateOfBirth());
      }
      if (user.getUserBiography() != null) {
        actualUser.setUserBiography(user.getUserBiography());
      }
    }
    return 1;
  }

  public User findUserByUsername(String username) {
    return repository.findUserByUsername(username);
  }

  public User findUserByCredentials(String username, String password) {
    return repository.findUserByCredentials(username, password);
  }

}
