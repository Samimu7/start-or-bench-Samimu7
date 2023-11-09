package com.samimu7.startorbench.controller;

import com.samimu7.startorbench.service.FootballDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private FootballDataService footballDataService;

    @GetMapping("/champions-league")
    public ResponseEntity<Object> getChampionsLeagueMatches(@RequestParam String date) {
        footballDataService.fetchChampionsLeagueMatches(date);
        return ResponseEntity.ok(footballDataService.getChampionsLeagueMatches());
    }

    @GetMapping("/champions-league/with-lineups")
    public ResponseEntity<Object> getChampionsLeagueMatchesWithLineups(@RequestParam String date) {
        footballDataService.fetchChampionsLeagueMatchesWithLineups(date);
        return ResponseEntity.ok(footballDataService.getChampionsLeagueMatches());
    }

    @GetMapping("/champions-league/{fixtureId}/lineups")
    public ResponseEntity<Object> getLineup(@PathVariable int fixtureId) {
        return ResponseEntity.ok(footballDataService.getLineup(fixtureId));
    }

    @PutMapping("/champions-league/{fixtureId}/lineups/{playerId}")
    public ResponseEntity<String> updatePlayerStatus(
            @PathVariable int fixtureId,
            @PathVariable int playerId,
            @RequestParam boolean shouldStart
    ) {
        footballDataService.updatePlayerStatus(fixtureId, playerId, shouldStart);
        return ResponseEntity.ok("Player status updated successfully.");
    }

    @GetMapping("/teams/{teamId}")
    public ResponseEntity<Object> getTeamById(@PathVariable Long teamId) {
        return ResponseEntity.ok(footballDataService.getTeamById(teamId));
    }

    @GetMapping("/players/{playerId}")
    public ResponseEntity<Object> getPlayerById(@PathVariable Long playerId) {
        return ResponseEntity.ok(footballDataService.getPlayerById(playerId));
    }

    @GetMapping("/lineups/{matchId}")
    public ResponseEntity<Object> getLineupByMatchId(@PathVariable Long matchId) {
        return ResponseEntity.ok(footballDataService.getLineupByMatchId(matchId));
    }
}
