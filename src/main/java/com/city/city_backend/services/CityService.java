package com.city.city_backend.services;

import java.util.List;

import com.city.city_backend.repositories.CityRepository;
import com.city.city_backend.entities.City;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> getCities() {
        return repository.findAll();
    }

    public City getCityById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("City not Found!"));
    }

    public City createCity(City city) {
        return repository.save(city);
    }

    public void deleteById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("City not Found!");
        }
    }

    public void updateCity(int id, City city) {
        City newCity = repository.getReferenceById(id);
        newCity.setContinent(city.getContinent());
        newCity.setCountry(city.getCountry());
        newCity.setState(city.getState());
        newCity.setCity(city.getCity());
        newCity.setPopulation(city.getPopulation());
        newCity.setArea(city.getArea());
        repository.save(newCity);
    }
}