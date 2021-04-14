package com.example.wbdvsp21myMarathonJourneyserverjava.controllers;

import com.example.wbdvsp21myMarathonJourneyserverjava.models.RaceJourney;
import com.example.wbdvsp21myMarathonJourneyserverjava.services.RaceJourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RaceJourneyController {
  @Autowired
  RaceJourneyService service;

  @PostMapping("/api/users/{uid}/raceJourneys")
  public RaceJourney createWidgetForTopic(
          @PathVariable("uid") String userId,
          @RequestBody RaceJourney raceJourney
  ) {
    return service.createRaceJourney(userId, raceJourney);
  }

  @GetMapping("/api/raceJourneys")
  public List<RaceJourney> findAllRaceJourneys() {
    return service.findAllRaceJourneys();
  }

  @GetMapping("/api/users/{uid}/raceJourneys")
  public List<RaceJourney> findRaceJourneysForUser(
          @PathVariable("uid") String userId
  ) {
    return service.findRaceJourneyForUser(userId);
  }

  @DeleteMapping("/api/raceJourneys/{rJid}")
  public Integer deleteRaceJourney(
          @PathVariable("rJid") Long id) {
    return service.deleteRaceJourney(id);
  }

  @PutMapping("/api/raceJourneys/{rJid}")
  public Integer updateRaceJourney(
          @PathVariable("rJid") Long id,
          @RequestBody RaceJourney raceJourney) {
    return service.updateRaceJourney(id, raceJourney);
  }
}