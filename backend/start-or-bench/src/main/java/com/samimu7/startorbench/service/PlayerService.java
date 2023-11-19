package com.samimu7.startorbench.service;

import com.samimu7.startorbench.model.Player;
import com.samimu7.startorbench.repository.PlayerRepository;
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
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            player.setBenchedVotes(player.getBenchedVotes() + 1);
            return playerRepository.save(player);
        } else {
            throw new RuntimeException("Player not found with id: " + playerId);
        }
    }
}

