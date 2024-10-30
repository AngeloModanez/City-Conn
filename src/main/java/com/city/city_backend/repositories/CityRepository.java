package com.city.city_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.city.city_backend.entities.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}