import React, { useState, useEffect } from "react";
import "./App.css";
import { Fixture, Lineup, Player, getFixtures, getLineup } from "./api";
import FixtureList from "./FixtureList";
import LineupComponent from "./LineupComponent";

function App() {
  const [fixtures, setFixtures] = useState<Fixture[]>([]);
  const [selectedFixture, setSelectedFixture] = useState<Fixture | null>(null);
  const [lineup, setLineup] = useState<Lineup | null>(null);

  useEffect(() => {
    async function fetchData() {
      try {
        const fixturesData = await getFixtures();
        setFixtures(fixturesData);
      } catch (error) {
        console.error("Error fetching fixtures:", error);
      }
    }

    fetchData();
  }, []);

  useEffect(() => {
    async function fetchLineup() {
      if (selectedFixture) {
        try {
          const lineupData = await getLineup(selectedFixture.fixtureId);
          setLineup(lineupData);
        } catch (error) {
          console.error("Error fetching lineup:", error);
        }
      }
    }

    fetchLineup();
  }, [selectedFixture]);

  const handleFixtureClick = (fixture: Fixture) => {
    setSelectedFixture(fixture);
  };

  const handlePlayerVote = (player: Player) => {
    console.log(`Voted to bench player: ${player.name}`);
    player.votesToBench = (player.votesToBench || 0) + 1;
    setLineup((prevLineup) => {
      if (!prevLineup) return null;
      const updatedLineup = {
        ...prevLineup,
        [selectedFixture?.teamOne.includes(player) ? "teamOne" : "teamTwo"]: prevLineup[selectedFixture?.teamOne.includes(player) ? "teamOne" : "teamTwo"].map((p) =>
          p.playerId === player.playerId ? player : p
        ),
      };
      return updatedLineup;
    });
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>ShouldBeBenched</h1>
      </header>
      <FixtureList fixtures={fixtures} onFixtureClick={handleFixtureClick} />
      <LineupComponent
        selectedFixture={selectedFixture}
        lineup={lineup}
        onPlayerVote={handlePlayerVote}
      />
    </div>
  );
}

export default App;
