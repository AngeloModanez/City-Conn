package com.city.city_backend.resources;

import java.util.List;

import com.city.city_backend.services.CityService;
import com.city.city_backend.entities.City;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("cities")
    public List<City> getCities() {
        return service.getCities();
    }
}