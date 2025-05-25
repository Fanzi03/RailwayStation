package org.example.repository;

import org.example.model.entity.RailwayStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RailwayStationRepository extends JpaRepository<RailwayStation, Long> {
    Optional<RailwayStation> findByName(String name);
}
