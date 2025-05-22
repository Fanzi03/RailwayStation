package org.example.service;

import org.example.model.entity.RailwayStation;


import java.util.List;
import java.util.Optional;

public interface RailwayStationService {
    List<RailwayStation> findAll();
    Optional<RailwayStation> findByName(String name);
    void save(RailwayStation railwayStation);
    void delete(RailwayStation railwayStation);
    void update(RailwayStation railwayStation, Long id);
}
