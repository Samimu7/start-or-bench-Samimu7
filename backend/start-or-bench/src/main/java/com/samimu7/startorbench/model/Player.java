package com.samimu7.startorbench.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shouldStart")
    private boolean shouldStart;

    // Other properties...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShouldStart() {
        return shouldStart;
    }

    public void setShouldStart(boolean shouldStart) {
        this.shouldStart = shouldStart;
    }

    // Other getters and setters...
}
