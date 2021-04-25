package com.example.wbdvsp21myMarathonJourneyserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="RaceJourney")
public class RaceJourney {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String raceId;
  private String raceName;
  private String raceMonth;
  private String raceURL;
  private String userId;
  private String raceLogo;
  private String raceDate;




  public RaceJourney(Long id, String raceId, String raceName, String raceMonth, String raceURL,
                     String userId, String raceLogo, String raceDate) {
    this.id = id;
    this.raceId = raceId;
    this.raceName = raceName;
    this.raceMonth = raceMonth;
    this.raceURL = raceURL;
    this.userId = userId;
    this.raceLogo = raceLogo;
    this.raceDate = raceDate;

  }

  public RaceJourney() {
  }

  public String getRaceDate() {
    return raceDate;
  }

  public void setRaceDate(String raceDate) {
    this.raceDate = raceDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRaceId() {
    return raceId;
  }

  public void setRaceId(String raceId) {
    this.raceId = raceId;
  }

  public String getRaceName() {
    return raceName;
  }

  public void setRaceName(String raceName) {
    this.raceName = raceName;
  }

  public String getRaceMonth() {
    return raceMonth;
  }

  public void setRaceMonth(String raceMonth) {
    this.raceMonth = raceMonth;
  }

  public String getRaceURL() {
    return raceURL;
  }

  public void setRaceURL(String raceURL) {
    this.raceURL = raceURL;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getRaceLogo() {
    return raceLogo;
  }

  public void setRaceLogo(String raceLogo) {
    this.raceLogo = raceLogo;
  }
}
