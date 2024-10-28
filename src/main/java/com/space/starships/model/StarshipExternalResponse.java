package com.space.starships.model;

public class StarshipExternalResponse {
    private int count;
    private String next;
    private String previous;
    private Starship[] results;

    public Starship[] getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }
}