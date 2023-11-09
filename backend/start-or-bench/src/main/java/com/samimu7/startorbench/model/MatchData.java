package com.samimu7.startorbench.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MatchData {
    @JsonProperty("fixture")
    private Fixture fixture;

    @JsonProperty("league")
    private League league;

    @JsonProperty("teams")
    private Teams teams;

    @JsonProperty("lineups")
    private List<Player> lineups;

    @JsonProperty("date")
    private String date;

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public List<Player> getLineups() {
        return lineups;
    }

    public void setLineups(List<Player> lineups) {
        this.lineups = lineups;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
