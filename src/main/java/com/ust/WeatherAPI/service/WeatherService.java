package com.ust.WeatherAPI.service;

import com.ust.WeatherAPI.config.WeatherApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final WeatherApiConfig weatherApiConfig;

    @Autowired
    public WeatherService(RestTemplate restTemplate, WeatherApiConfig weatherApiConfig) {
        this.restTemplate = restTemplate;
        this.weatherApiConfig = weatherApiConfig;
    }

    public String getWeather(String city) {
        String url = String.format("%s/weather?q=%s&appid=%s",
                weatherApiConfig.getApiUrl(), city, weatherApiConfig.getApiKey());

        return restTemplate.getForObject(url, String.class);
    }
}
