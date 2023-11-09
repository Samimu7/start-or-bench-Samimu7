package com.samimu7.startorbench.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {

    @JsonProperty("id")
    private int id;

    // Add getters and setters as needed

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
