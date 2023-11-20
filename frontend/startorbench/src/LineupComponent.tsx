import React from "react";
import { Lineup, Player } from "./api";

interface LineupProps {
  selectedFixture: Fixture | null;
  lineup: Lineup | null;
  onPlayerVote: (player: Player) => void;
}

function LineupComponent({ selectedFixture, lineup, onPlayerVote }: LineupProps) {
  return (
    <div className="lineup">
      {selectedFixture && (
        <>
          <h2>Lineup</h2>
          <div className="team">
            <h3>{selectedFixture.teamOne}</h3>
            <ul>
              {lineup?.teamOne.map((player) => (
                <li key={player.playerId} className="player-item">
                  <span className="player-name">{player.name}</span>
                  <button className="vote-button" onClick={() => onPlayerVote(player)}>
                    Should be benched
                  </button>
                  <span className="votes">{player.votesToBench || 0} votes</span>
                </li>
              ))}
            </ul>
          </div>
          <div className="team">
            <h3>{selectedFixture.teamTwo}</h3>
            <ul>
              {lineup?.teamTwo.map((player) => (
                <li key={player.playerId} className="player-item">
                  <span className="player-name">{player.name}</span>
                  <button className="vote-button" onClick={() => onPlayerVote(player)}>
                    Should be benched
                  </button>
                  <span className="votes">{player.votesToBench || 0} votes</span>
                </li>
              ))}
            </ul>
          </div>
        </>
      )}
    </div>
  );
}

export default LineupComponent;
