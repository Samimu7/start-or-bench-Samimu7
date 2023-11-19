package com.samimu7.startorbench.controller;

import com.samimu7.startorbench.model.Player;
import com.samimu7.startorbench.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/{id}/vote-bench")
    public ResponseEntity<Player> votePlayerBenched(@PathVariable Long id) {
        try {
            Player updatedPlayer = playerService.votePlayerBenched(id);
            return ResponseEntity.ok(updatedPlayer);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
