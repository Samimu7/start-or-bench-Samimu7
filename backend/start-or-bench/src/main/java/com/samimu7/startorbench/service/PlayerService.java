package com.samimu7.startorbench.service;

import com.samimu7.startorbench.model.Player;
import com.samimu7.startorbench.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }



    public Player votePlayerBenched(Long playerId) {
        return playerRepository.findById(playerId).map(player -> {
            player.setBenchedVotes(player.getBenchedVotes() + 1);
            return playerRepository.save(player);
        }).orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + playerId));
    }

}

