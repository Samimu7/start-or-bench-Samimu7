package com.samimu7.startorbench.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fixtureId; // New field
    private String teamOne;
    private String teamTwo;
    private LocalDate date;
    private LocalTime time;
    private String venue;

    // Constructors, getters, and setters
    public int getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(int fixtureId) {
        this.fixtureId = fixtureId;
    }


    public Match() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTeamOne() { return teamOne; }
    public void setTeamOne(String teamOne) { this.teamOne = teamOne; }
    public String getTeamTwo() { return teamTwo; }
    public void setTeamTwo(String teamTwo) { this.teamTwo = teamTwo; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
}
