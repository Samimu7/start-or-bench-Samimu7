import React from "react";
import { Lineup } from "./api";

interface LineupProps {
  lineup: Lineup;
  selectedFixture: number | null;
}

function LineupComponent({ lineup, selectedFixture }: LineupProps) {
  const teamOne = lineup.teamOne || [];
  const teamTwo = lineup.teamTwo || [];

  const handleVote = (playerId: number) => {
    
    alert(`Player with ID ${playerId} voted to be benched.`);
  };

  return (
    <div>
      <h2>Lineup for Fixture {selectedFixture}</h2>
      <div>
        <h3>Team One</h3>
        <ul>
          {teamOne.map((player) => (
            <li key={player.playerId}>
              {player.name} - {player.position}
              <button onClick={() => handleVote(player.playerId)}>
                Should be benched
              </button>
            </li>
          ))}
        </ul>
      </div>
      <div>
        <h3>Team Two</h3>
        <ul>
          {teamTwo.map((player) => (
            <li key={player.playerId}>
              {player.name} - {player.position}
              <button onClick={() => handleVote(player.playerId)}>
                Should be benched
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default LineupComponent;
