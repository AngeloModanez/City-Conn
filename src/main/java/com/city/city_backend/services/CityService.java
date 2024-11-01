package com.city.city_backend.services;

import java.util.List;

import com.city.city_backend.repositories.CityRepository;
import com.city.city_backend.entities.City;
import com.city.city_backend.dtos.CityRequest;
import com.city.city_backend.mappers.CityMapper;
import com.city.city_backend.dtos.CityResponse;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<CityResponse> getCities() {
        return repository.findAll().stream().map(city -> CityMapper.toDto(city)).toList();
    }

    public CityResponse getCityById(int id) {
        City city = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("City not Found!"));
        return CityMapper.toDto(city);
    }

    public CityResponse createCity(CityRequest dtoRequestCity) {
        City city = repository.save(CityMapper.toEntity(dtoRequestCity));
        return CityMapper.toDto(city);
    }

    public void deleteById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("City not Found!");
        }
    }

    public void updateCity(int id, CityRequest dtoRequestCity) {
        City newCity = repository.getReferenceById(id);
        newCity.setContinent(dtoRequestCity.continent());
        newCity.setCountry(dtoRequestCity.country());
        newCity.setState(dtoRequestCity.state());
        newCity.setCity(dtoRequestCity.city());
        newCity.setPopulation(dtoRequestCity.population());
        newCity.setArea(dtoRequestCity.area());
        repository.save(newCity);
    }
}