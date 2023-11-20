// src/api.ts
export interface Fixture {
    id: number;
    fixtureId: number;
    teamOne: string;
    teamTwo: string;
    date: string;
    time: string;
    venue: string;
  }
  
  export interface Player {
    playerId: number;
    name: string;
    position: string;
  }
  
  export interface Lineup {
    teamOne: Player[];
    teamTwo: Player[];
  }
  
  export const fixtures: Fixture[] = [
    {
      id: 1,
      fixtureId: 1,
      teamOne: "Real Madrid",
      teamTwo: "Barcelona",
      date: "2023-12-03",
      time: "19:00:00",
      venue: "Santiago Bernabéu Stadium",
    },
    {
      id: 2,
      fixtureId: 2,
      teamOne: "Liverpool",
      teamTwo: "Manchester United",
      date: "2023-12-04",
      time: "16:00:00",
      venue: "Anfield",
    },
  ];
  
  export const lineups: Record<number, Lineup> = {
    1: {
      teamOne: [
        { playerId: 101, name: "Thibaut Courtois", position: "GK" },
        { playerId: 102, name: "Sergio Ramos", position: "CB" },
        { playerId: 103, name: "Raphael Varane", position: "CB" },
        { playerId: 104, name: "Marcelo", position: "LB" },
        { playerId: 105, name: "Dani Carvajal", position: "RB" },
        { playerId: 106, name: "Luka Modric", position: "MF" },
        { playerId: 107, name: "Toni Kroos", position: "MF" },
        { playerId: 108, name: "Casemiro", position: "MF" },
        { playerId: 109, name: "Isco", position: "MF" },
        { playerId: 110, name: "Karim Benzema", position: "STR" },
        { playerId: 111, name: "Eden Hazard", position: "STR" },
      ],
      teamTwo: [
        { playerId: 201, name: "Marc ter Stegen", position: "GK" },
        { playerId: 202, name: "Gerard Piqué", position: "CB" },
        { playerId: 203, name: "Clément Lenglet", position: "CB" },
        { playerId: 204, name: "Jordi Alba", position: "LB" },
        { playerId: 205, name: "Sergi Roberto", position: "RB" },
        { playerId: 206, name: "Sergio Busquets", position: "MF" },
        { playerId: 207, name: "Frenkie de Jong", position: "MF" },
        { playerId: 208, name: "Pedri", position: "MF" },
        { playerId: 209, name: "Ansu Fati", position: "MF" },
        { playerId: 210, name: "Lionel Messi", position: "STR" },
        { playerId: 211, name: "Antoine Griezmann", position: "STR" },
      ],
    },
    2: {
      teamOne: [
        { playerId: 301, name: "Alisson Becker", position: "GK" },
        { playerId: 302, name: "Virgil van Dijk", position: "CB" },
        { playerId: 303, name: "Joe Gomez", position: "CB" },
        { playerId: 304, name: "Andrew Robertson", position: "LB" },
        { playerId: 305, name: "Trent Alexander", position: "RB" },
        { playerId: 306, name: "Jordan Henderson", position: "MF" },
        { playerId: 307, name: "Thiago", position: "MF" },
        { playerId: 308, name: "Fabinho", position: "MF" },
        { playerId: 309, name: "Sadio Mané", position: "MF" },
        { playerId: 310, name: "Mohamed Salah", position: "STR" },
        { playerId: 311, name: "Roberto Firmino", position: "STR" },
      ],
      teamTwo: [
        { playerId: 401, name: "David de Gea", position: "GK" },
        { playerId: 402, name: "Harry Maguire", position: "CB" },
        { playerId: 403, name: "Victor Lindelöf", position: "CB" },
        { playerId: 404, name: "Luke Shaw", position: "LB" },
        { playerId: 405, name: "Aaron Bissaka", position: "RB" },
        { playerId: 406, name: "Paul Pogba", position: "MF" },
        { playerId: 407, name: "Bruno Fernandes", position: "MF" },
        { playerId: 408, name: "Fred", position: "MF" },
        { playerId: 409, name: "Donny Beek", position: "MF" },
        { playerId: 410, name: "Marcus Rashford", position: "STR" },
        { playerId: 411, name: "Mason Greenwood", position: "STR" },
      ],
    },
  };
  
  export function getFixtures(): Promise<Fixture[]> {
    return Promise.resolve(fixtures);
  }
  
  export function getLineup(fixtureId: number): Promise<Lineup> {
    return Promise.resolve(lineups[fixtureId] || { teamOne: [], teamTwo: [] });
  }
  