package com.space.starships.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.space.starships.exception.ExternalApiException;
import com.space.starships.model.Starship;
import com.space.starships.model.StarshipExternalResponse;
import com.space.starships.model.StarshipResponse;

@Service
public class StarshipService {

    private final String URL = "https://swapi.dev/api/starships";

    @Autowired
    private RestTemplate restTemplate;

    public List<StarshipResponse> getStarships() {

        List<Starship> starships = getStarshipsFromExternal().stream().limit(10).toList();

        List<StarshipResponse> returns = new ArrayList<>();

        for (Starship ship : starships) {
            returns.add(new StarshipResponse(ship.name(), Long.valueOf(ship.cost_in_credits()), ship.url()));
        }

        return returns;
    }

    private TreeSet<Starship> getStarshipsFromExternal() {

        boolean hasMore = true;

        int page = 1;

        TreeSet<Starship> starships = new TreeSet<>();

        while (hasMore) {

            String requestUrl = UriComponentsBuilder.fromHttpUrl(URL).queryParam("page", page).toUriString();

            try {
                // Get starships from external API from all pages
                StarshipExternalResponse res = restTemplate.getForObject(requestUrl, StarshipExternalResponse.class);

                if (res != null) {
                    starships.addAll(Arrays.asList(res.getResults()));

                    if (res.getNext() == null) {
                        hasMore = false;
                    }
                }

            } catch (HttpStatusCodeException e) {
                System.err.println("HTTP Status Code: " + e.getStatusCode());
                throw new ExternalApiException("External call failed ", e);
            } catch (RestClientException e) {
                System.err.println("Failed to get starships");
                throw new ExternalApiException(e.getMessage());
            }

            page++;
        }
        return starships;
    }

}
