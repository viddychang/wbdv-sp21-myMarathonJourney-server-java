package com.example.wbdvsp21myMarathonJourneyserverjava.services;

import com.example.wbdvsp21myMarathonJourneyserverjava.models.RaceJourney;
import com.example.wbdvsp21myMarathonJourneyserverjava.repositories.RaceJourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceJourneyService {
  @Autowired
  RaceJourneyRepository repository;

  public RaceJourney createRaceJourney(String userId, RaceJourney raceJourney) {
    raceJourney.setUserId(userId);
    return repository.save(raceJourney);
  }

  public List<RaceJourney> findAllRaceJourneys() {
    return (List<RaceJourney>) repository.findAll();
  }

  public List<RaceJourney> findRaceJourneyForUser(String userId) {
    return repository.findRaceJourneyForUser(userId);
  }

  public Integer deleteRaceJourney(Long id) {
    repository.deleteById(id);
    return 1;
  }

  public Integer updateRaceJourney(Long id, RaceJourney raceJourney) {
    if (repository.findById(id).isPresent()) {
      RaceJourney actualRaceJourney = repository.findById(id).get();

      if (raceJourney.getRaceId() != null) {
        actualRaceJourney.setRaceId(raceJourney.getRaceId());
      }

      if (raceJourney.getRaceName() != null) {
        actualRaceJourney.setRaceName(raceJourney.getRaceName());
      }

      if (raceJourney.getRaceMonth() != null) {
        actualRaceJourney.setRaceMonth(raceJourney.getRaceMonth());
      }

      if (raceJourney.getRaceURL() != null) {
        actualRaceJourney.setRaceURL(raceJourney.getRaceURL());
      }

      if (raceJourney.getUserId() != null) {
        actualRaceJourney.setRaceId(raceJourney.getUserId());
      }
      repository.save(actualRaceJourney);
    }

    return 1;
  }
}
