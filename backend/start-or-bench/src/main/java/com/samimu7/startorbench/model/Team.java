package com.samimu7.startorbench.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Player> players;

    // Constructors
    public Team() {}

    // Standard getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Player> getPlayers() { return players; }
    public void setPlayers(Set<Player> players) { this.players = players; }
}
