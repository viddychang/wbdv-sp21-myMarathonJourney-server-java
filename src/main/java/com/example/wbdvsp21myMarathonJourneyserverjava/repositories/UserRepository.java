package com.example.wbdvsp21myMarathonJourneyserverjava.repositories;

import com.example.wbdvsp21myMarathonJourneyserverjava.models.RaceJourney;
import com.example.wbdvsp21myMarathonJourneyserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>  {
  @Query(value = "SELECT user FROM User user")
  public List<User> findAllUsers();

  @Query(value = "SELECT * FROM User WHERE user_id=:uid", nativeQuery = true)
  public User findUserById(@Param("uid") Long userId);

  @Query(value = "SELECT * FROM User WHERE user_name:username", nativeQuery = true)
  public User findUserByUsername(@Param("username") String username);


  @Query(value = "SELECT * FROM User WHERE user_name LIKE '%:username%'", nativeQuery = true)
  public List<User> findUserListByUserName(@Param("username") String username);

  @Query(value = "SELECT * FROM User WHERE user_name=:username and password=:password", nativeQuery = true)
  public User findUserByCredentials(@Param("username") String username, @Param("password") String password);
}
