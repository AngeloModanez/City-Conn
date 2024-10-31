package com.city.city_backend.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record CityRequest(

                @NotBlank(message = "Continent cannot be blank") 
                @Size(min = 3, message = "Minimum length for the name is 3") 
                @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Continent must contain only letters and spaces") 
                String continent,

                @NotBlank(message = "Country name cannot be blank") 
                @Size(min = 3, message = "Minimum length for the name is 3") 
                @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Country name must contain only letters and spaces") 
                String country,

                @NotBlank(message = "State name cannot be blank") 
                @Size(min = 3, message = "Minimum length for the name is 3") 
                @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "State name must contain only letters and spaces") 
                String state,

                @NotBlank(message = "City name cannot be blank") 
                @Size(min = 3, message = "Minimum length for the name is 3") 
                @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "City name must contain only letters and spaces") 
                String city,

                @NotNull(message = "Population cannot be null") 
                @Positive(message = "Population must be positive") 
                @Min(value = 100, message = "Population must be at least 100") 
                int population,

                @NotNull(message = "Area cannot be null") 
                @Positive(message = "Area must be positive") 
                float area) {
}