package com.city.city_backend.resources;

import java.util.List;

import com.city.city_backend.entities.City;
import com.city.city_backend.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityRepository repository;

    @GetMapping("cities")
    public List<City> getCity() {
        return repository.findAll();
    }
}