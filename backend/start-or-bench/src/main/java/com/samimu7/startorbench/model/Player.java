package com.samimu7.startorbench.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int benchedVotes;

    public int getBenchedVotes() {
        return benchedVotes;
    }

    public void setBenchedVotes(int benchedVotes) {
        this.benchedVotes = benchedVotes;
    }
}


