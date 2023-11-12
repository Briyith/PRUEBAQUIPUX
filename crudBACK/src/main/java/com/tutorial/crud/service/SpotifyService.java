package com.tutorial.crud.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class SpotifyService {

    @Value("${spotify.api.url}")
    private String spotifyApiUrl;

    @Value("${spotify.api.token}")
    private String spotifyApiToken;

    public List<String> getAvailableGenres() {
        String endpoint = "/v1/recommendations/available-genre-seeds";

        String apiUrl = spotifyApiUrl + endpoint;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + spotifyApiToken);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Object>>() {}
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> responseBody = response.getBody();
            List<String> genres = (List<String>) responseBody.get("genres");
            return genres;
        } else {
            // Manejo de errores
            return Collections.emptyList();
        }
    }
}