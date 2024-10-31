package com.city.city_backend.dtos;

public record CityRequest(
        String continent,
        String country,
        String state,
        String city,
        int population,
        float area) {
}