package com.city.city_backend.services;

import java.util.List;

import com.city.city_backend.repositories.CityRepository;
import com.city.city_backend.entities.City;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> getCities() {
        return repository.findAll();
    }
}