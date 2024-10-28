package com.space.starships.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.space.starships.model.StarshipResponse;
import com.space.starships.service.StarshipService;

@RestController
@RequestMapping("/api/")
public class StarshipController {

    @Autowired
    private StarshipService starshipService;

    @GetMapping("/starships")
    public ResponseEntity<List<StarshipResponse>> getReceivedMessages() {
        return ResponseEntity.ok(starshipService.getStarships());
    }
}
