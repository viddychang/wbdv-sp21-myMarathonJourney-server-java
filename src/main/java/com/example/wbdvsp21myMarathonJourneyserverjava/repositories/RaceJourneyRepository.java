package com.example.wbdvsp21myMarathonJourneyserverjava.repositories;


import com.example.wbdvsp21myMarathonJourneyserverjava.models.RaceJourney;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RaceJourneyRepository extends CrudRepository<RaceJourney, Long>{
  @Query(value = "SELECT * FROM RaceJourney WHERE user_id=:uid", nativeQuery = true)
  public List<RaceJourney> findRaceJourneyForUser(@Param("uid") String userId);

}
