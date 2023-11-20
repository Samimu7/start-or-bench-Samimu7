// src/FixtureList.tsx
import React from "react";
import { Fixture } from "./api";

interface FixtureListProps {
  fixtures: Fixture[];
  onSelect: (fixtureId: number) => void;
}

function FixtureList({ fixtures, onSelect }: FixtureListProps) {
  return (
    <div>
      <h2>Fixtures</h2>
      <ul>
        {fixtures.map((fixture) => (
          <li key={fixture.id}>
            <button onClick={() => onSelect(fixture.fixtureId)} className="fixture-button">
              <img src="url_to_team_logo" alt="Team Logo" className="team-logo" />
              {fixture.teamOne} vs {fixture.teamTwo}
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FixtureList;