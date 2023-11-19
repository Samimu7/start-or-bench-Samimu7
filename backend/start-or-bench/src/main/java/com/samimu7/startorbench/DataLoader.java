package com.samimu7.startorbench;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samimu7.startorbench.service.MatchService;
import com.samimu7.startorbench.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TeamService teamService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
    }
}
