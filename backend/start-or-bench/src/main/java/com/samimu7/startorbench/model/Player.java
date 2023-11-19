package com.samimu7.startorbench.model;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    private int benchedVotes;

    // Constructors, getters, and setters
    // Constructor matching the lambda expression
    public Player(String name, String position, Team team) {
        this.name = name;
        this.position = position;
        this.team = team;
    }

    // No-arg constructor for JPA
    public Player() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public int getBenchedVotes() { return benchedVotes; }
    public void setBenchedVotes(int benchedVotes) { this.benchedVotes = benchedVotes; }
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}
