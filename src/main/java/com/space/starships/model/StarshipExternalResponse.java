package com.space.starships.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarshipExternalResponse {
    private int count;
    private String next;
    private String previous;
    private Starship[] results;
}
