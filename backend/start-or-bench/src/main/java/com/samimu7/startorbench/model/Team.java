package com.samimu7.startorbench.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Player> players;

    @Transient
    private List<PlayerData> playerData;

    public Team() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Player> getPlayers() { return players; }
    public void setPlayers(Set<Player> players) { this.players = players; }
    public List<PlayerData> getPlayerData() { return playerData; }
    public void setPlayerData(List<PlayerData> playerData) { this.playerData = playerData; }

    // Nested PlayerData class for JSON structure
    public static class PlayerData {
        private String name;
        private String position;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
    }
}
