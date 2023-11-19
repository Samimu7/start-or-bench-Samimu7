package com.samimu7.startorbench.repository;

import com.samimu7.startorbench.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findByFixtureId(int fixtureId);
}
