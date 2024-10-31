package com.city.city_backend.resources;

import java.util.List;
import java.net.URI;

import com.city.city_backend.services.CityService;
import com.city.city_backend.dtos.CityRequest;
import com.city.city_backend.dtos.CityResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CityController {
    private CityService service;

    public CityController(CityService cityService) {
        this.service = cityService;
    }

    // Status code: 200 - Ok
    @GetMapping("cities")
    public ResponseEntity<List<CityResponse>> getCities() {
        return ResponseEntity.ok(service.getCities());
    }

    // Status code: 200 - Ok
    @GetMapping("cities/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCityById(id));
    }

    // Status code: 201 - Created
    @PostMapping("cities")
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest city) {
        CityResponse newCity = service.createCity(city);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCity.id())
                .toUri();
        return ResponseEntity.created(location).body(newCity);
    }

    // Status code: 204 - No Content
    @DeleteMapping("cities/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Status code: 200 - Ok
    @PutMapping("cities/{id}")
    public ResponseEntity<Void> updateCity(@PathVariable int id, @RequestBody CityRequest city) {
        service.updateCity(id, city);
        return ResponseEntity.ok().build();
    }
}