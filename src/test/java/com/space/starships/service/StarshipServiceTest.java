package com.space.starships.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StarshipServiceTest {

    @Autowired
    StarshipService starshipService;

    @Test
    void testGetStarships() {
        var starships = starshipService.getStarships();
        assertEquals(starships.size(), 10);
        assertEquals(starships.get(0).price(), 1000000000000L);

    }
}