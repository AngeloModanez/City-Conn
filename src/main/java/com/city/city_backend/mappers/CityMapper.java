package com.city.city_backend.mappers;

import com.city.city_backend.entities.City;
import com.city.city_backend.dtos.CityRequest;
import com.city.city_backend.dtos.CityResponse;

public class CityMapper {
    public static City toEntity(CityRequest request) {
        City city = new City();
        city.setContinent(request.continent());
        city.setCountry(request.country());
        city.setState(request.state());
        city.setCity(request.city());
        city.setPopulation(request.population());
        city.setArea(request.area());
        return city;
    }

    public static CityResponse toDto(City city) {
        return new CityResponse(
                city.getId(),
                city.getContinent(),
                city.getCountry(),
                city.getState(),
                city.getCity(),
                city.getPopulation(),
                city.getArea());
    }
}