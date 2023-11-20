import React, { useState, useEffect } from "react";
import "./App.css";
import { Fixture, Lineup, Player, getFixtures, getLineup } from "./api";

function App() {
  const [fixtures, setFixtures] = useState<Fixture[]>([]);
  const [selectedFixture, setSelectedFixture] = useState<Fixture | null>(null);
  const [lineup, setLineup] = useState<Lineup | null>(null);
  const [darkMode, setDarkMode] = useState<boolean>(true); // Default to dark mode

  // Toggle dark mode
  const toggleDarkMode = () => {
    setDarkMode(!darkMode);
  };

  // Load fixtures when the component mounts
  useEffect(() => {
    getFixtures().then((data) => setFixtures(data));
  }, []);

  // Load lineup when a fixture is selected
  useEffect(() => {
    if (selectedFixture) {
      getLineup(selectedFixture.fixtureId).then((data) => setLineup(data));
    }
  }, [selectedFixture]);

  const handleFixtureClick = (fixture: Fixture) => {
    setSelectedFixture(fixture);
  };

  const handlePlayerVote = (player: Player) => {
    // You can implement the logic for voting here
    console.log(`Voted to bench player: ${player.name}`);
    // Increment the votesToBench counter for the player
    player.votesToBench = (player.votesToBench || 0) + 1;
    setLineup((prevLineup) => {
      if (!prevLineup) return null;
      return {
        ...prevLineup,
        [selectedFixture?.teamOne.includes(player) ? "teamOne" : "teamTwo"]: prevLineup[selectedFixture?.teamOne.includes(player) ? "teamOne" : "teamTwo"].map((p) =>
          p.playerId === player.playerId ? player : p
        ),
      };
    });
  };

  return (
    <div className={`App ${darkMode ? "dark-mode" : ""}`}>
      <h1>ShouldBeBenched</h1>
      <div className="fixture-list">
        <h2>Fixtures</h2>
        <ul>
          {fixtures.map((fixture) => (
            <li key={fixture.id} onClick={() => handleFixtureClick(fixture)} className="fixture-item">
              {fixture.teamOne} vs {fixture.teamTwo}
            </li>
          ))}
        </ul>
      </div>
      <div className="lineup">
        {selectedFixture && (
          <>
            <h2>Lineup</h2>
            <h3>{selectedFixture.teamOne}</h3>
            <ul>
              {lineup?.teamOne.map((player) => (
                <li key={player.playerId} className="player-item">
                  <span className="player-name">{player.name}</span>
                  <button className="vote-button" onClick={() => handlePlayerVote(player)}>
                    Should be benched
                  </button>
                  <span className="votes">{player.votesToBench || 0} votes</span>
                </li>
              ))}
            </ul>
            <h3>{selectedFixture.teamTwo}</h3>
            <ul>
              {lineup?.teamTwo.map((player) => (
                <li key={player.playerId} className="player-item">
                  <span className="player-name">{player.name}</span>
                  <button className="vote-button" onClick={() => handlePlayerVote(player)}>
                    Should be benched
                  </button>
                  <span className="votes">{player.votesToBench || 0} votes</span>
                </li>
              ))}
            </ul>
          </>
        )}
      </div>
    </div>
  );
}

export default App;
