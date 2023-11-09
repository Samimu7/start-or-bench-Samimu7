package com.samimu7.startorbench.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.samimu7.startorbench.model.MatchData;
import com.samimu7.startorbench.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballDataService {

    private static final Logger logger = LoggerFactory.getLogger(FootballDataService.class);

    @Value("${api.football.key}")
    private String apiKey;

    @Value("${api.football.host}")
    private String apiHost;

    private MatchData[] championsLeagueMatches;

    private List<MatchData> championsLeagueLineups = new ArrayList<>();

    public void fetchChampionsLeagueMatches(String date) {
        logger.info("Fetching Champions League matches for date: {}", date);

        try {
            HttpResponse<String> response = Unirest.get("https://api-football-v1.p.rapidapi.com/v3/fixtures")
                    .queryString("date", date)
                    .queryString("league", "2")
                    .queryString("season", "2023")
                    .header("X-RapidAPI-Key", apiKey)
                    .header("X-RapidAPI-Host", apiHost)
                    .asString();

            if (response.getStatus() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                championsLeagueMatches = mapper.readValue(response.getBody(), MatchData[].class);

                for (MatchData match : championsLeagueMatches) {
                    formatMatches(match);
                }
            } else {
                logger.error("Failed to fetch Champions League matches. Status: {}", response.getStatus());
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching Champions League matches: ", e);
        }
    }

    public MatchData[] getChampionsLeagueMatches() {
        return championsLeagueMatches;
    }

    public MatchData getChampionsLeagueMatch(int fixtureId) {
        if (championsLeagueMatches != null) {
            for (MatchData match : championsLeagueMatches) {
                if (match.getFixture().getId() == fixtureId) {
                    return match;
                }
            }
        }
        return null;
    }

    public List<Player> getLineup(int fixtureId) {
        MatchData match = getChampionsLeagueMatch(fixtureId);
        if (match != null) {
            return match.getLineups();
        }
        return null;
    }

    public void fetchChampionsLeagueMatchesWithLineups(String date) {
        logger.info("Fetching Champions League matches with line-ups for date: {}", date);

        try {
            HttpResponse<String> response = Unirest.get("https://api-football-v1.p.rapidapi.com/v3/fixtures")
                    .queryString("date", date)
                    .queryString("league", "2")
                    .queryString("season", "2023")
                    .header("X-RapidAPI-Key", apiKey)
                    .header("X-RapidAPI-Host", apiHost)
                    .asString();

            if (response.getStatus() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                championsLeagueMatches = mapper.readValue(response.getBody(), MatchData[].class);

                for (MatchData match : championsLeagueMatches) {
                    formatMatches(match);
                    fetchAndPrintLineups(match.getFixture().getId());
                }
            } else {
                logger.error("Failed to fetch Champions League matches. Status: {}", response.getStatus());
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching Champions League matches: ", e);
        }
    }

    private void fetchAndPrintLineups(int fixtureId) {
        try {
            HttpResponse<String> lineupResponse = Unirest.get("https://api-football-v1.p.rapidapi.com/v3/fixtures/lineups")
                    .queryString("fixture", fixtureId)
                    .header("X-RapidAPI-Key", apiKey)
                    .header("X-RapidAPI-Host", apiHost)
                    .asString();

            if (lineupResponse.getStatus() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                MatchData matchWithLineup = mapper.readValue(lineupResponse.getBody(), MatchData.class);
                championsLeagueLineups.add(matchWithLineup);

                System.out.println("Line-ups for Fixture ID " + fixtureId + ":");
                System.out.println(lineupResponse.getBody());
                System.out.println("--------------------------------------------------");
            } else {
                logger.error("Failed to fetch line-ups for Fixture ID {}. Status: {}", fixtureId, lineupResponse.getStatus());
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching line-ups for Fixture ID {}: ", fixtureId, e);
        }
    }

    public void updatePlayerStatus(int fixtureId, int playerId, boolean shouldStart) {
        MatchData match = getChampionsLeagueMatch(fixtureId);
        if (match != null) {
            List<Player> lineups = match.getLineups();
            for (Player player : lineups) {
                if (player.getId() == playerId) {
                    player.setShouldStart(shouldStart);
                    System.out.println("Player " + player.getName() + " updated. Should start: " + shouldStart);
                    return;
                }
            }
        }
        System.out.println("Player not found with ID " + playerId + " in fixture ID " + fixtureId);
    }

    private void formatMatches(MatchData match) {
        System.out.println("Date: " + match.getDate());
        System.out.println("Fixture ID: " + match.getFixture().getId());
        System.out.println("Home Team: " + match.getTeams().getHome().getName() + " (ID: " + match.getTeams().getHome().getId() + ", Logo: " + match.getTeams().getHome().getLogo() + ")");
        System.out.println("Away Team: " + match.getTeams().getAway().getName() + " (ID: " + match.getTeams().getAway().getId() + ", Logo: " + match.getTeams().getAway().getLogo() + ")");
        System.out.println("League Logo: " + match.getLeague().getLogo());
        System.out.println("Season: " + match.getLeague().getSeason());
        System.out.println("--------------------------------------------------");
    }
}

