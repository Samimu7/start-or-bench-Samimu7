package com.samimu7.startorbench.service;

import com.samimu7.startorbench.model.Team;
import com.samimu7.startorbench.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Optional<Team> getTeamByName(String name) {
        return teamRepository.findByName(name);
    }
}

