import React from "react";
import { Fixture } from "./api";

interface FixtureListProps {
  fixtures: Fixture[];
  onFixtureClick: (fixture: Fixture) => void;
}

function FixtureList({ fixtures, onFixtureClick }: FixtureListProps) {
  return (
    <div className="fixture-list">
      <h2>Fixtures</h2>
      <ul>
        {fixtures.map((fixture) => (
          <li key={fixture.id} onClick={() => onFixtureClick(fixture)} className="fixture-item">
            {fixture.teamOne} vs {fixture.teamTwo}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FixtureList;
