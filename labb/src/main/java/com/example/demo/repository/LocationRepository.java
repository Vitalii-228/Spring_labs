package com.example.demo.repository;

import com.example.demo.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository<Location, Long> {

    Page<Location> findByCountry(String countryName, Pageable pageable);

    Location findByCity(String cityName);
}
