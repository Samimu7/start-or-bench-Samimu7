package com.samimu7.startorbench.repositorys;

import com.samimu7.startorbench.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Add custom query methods if needed
}