package com.city.city_backend.resources;

import java.util.List;

import com.city.city_backend.services.CityService;
import com.city.city_backend.entities.City;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("cities")
    public List<City> getCities() {
        return service.getCities();
    }

    @GetMapping("cities/{id}")
    public City getCityById(@PathVariable int id) {
        return service.getCityById(id);
    }

    @PostMapping("cities")
    public City createCity(@RequestBody City city) {
        return service.createCity(city);
    }

    @DeleteMapping("cities/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping("cities/{id}")
    public void updateCity(@PathVariable int id, @RequestBody City city) {
        service.updateCity(id, city);
    }
}