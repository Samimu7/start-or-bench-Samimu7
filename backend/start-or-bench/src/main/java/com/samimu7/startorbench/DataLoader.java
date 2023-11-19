package com.samimu7.startorbench;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samimu7.startorbench.model.Match;
import com.samimu7.startorbench.model.Player;
import com.samimu7.startorbench.model.Team;
import com.samimu7.startorbench.repository.MatchRepository;
import com.samimu7.startorbench.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public void run(String... args) throws Exception {
        // Load matches
        InputStream matchesStream = new ClassPathResource("matches.json").getInputStream();
        List<Match> matches = objectMapper.readValue(matchesStream, new TypeReference<List<Match>>() {});
        matchRepository.saveAll(matches);

        // Load teams
        InputStream teamsStream = new ClassPathResource("teams.json").getInputStream();
        List<Team> teams = objectMapper.readValue(teamsStream, new TypeReference<List<Team>>() {});
        teams.forEach(team -> {
            Set<Player> players = team.getPlayers().stream()
                    .map(playerJson -> new Player(playerJson.getName(), playerJson.getPosition(), team))
                    .collect(Collectors.toSet());
            team.setPlayers(players);
            teamRepository.save(team);
        });
    }
}
