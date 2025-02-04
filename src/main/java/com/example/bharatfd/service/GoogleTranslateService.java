package com.example.bharatfd.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Map;

import org.springframework.http.ResponseEntity;


@Service
public class GoogleTranslateService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String GOOGLE_SCRIPT_URL = "https://script.google.com/macros/s/AKfycby8gRcnyyB1XUe3vkUrFFJ_QQ3iLsotrrG3lynXtmcuad0XEhIRgJwdu5L0S1DyX5L7/exec";

    @Cacheable(value = "translations", key = "#text + #targetLang")
    public String translateText(String text, String targetLanguage) {
        String apiUrl = GOOGLE_SCRIPT_URL + "?q=" + text + "&target=" + targetLanguage;

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(apiUrl, Map.class);

            if (response.getBody() != null && response.getBody().containsKey("translatedText")) {
                return response.getBody().get("translatedText").toString();
            }
            return "Error: Invalid response format";
        } catch (Exception e) {
            return "Translation failed: " + e.getMessage();
        }
    }
}
