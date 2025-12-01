package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;

    @OneToMany(mappedBy = "location")
    private List<WeatherData> weatherData;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String cityName) {
        this.city = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryName) {
        this.country = countryName;
    }

    public List<WeatherData> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(List<WeatherData> weatherData) {
        this.weatherData = weatherData;
    }
}
