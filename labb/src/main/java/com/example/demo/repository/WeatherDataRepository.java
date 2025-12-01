package com.example.demo.repository;

import com.example.demo.domain.WeatherData;
import com.example.demo.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

@RepositoryRestResource
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    Page<WeatherData> findByDateGreaterThanEqualAndLocation(Date date, Location location, Pageable pageable);
}
