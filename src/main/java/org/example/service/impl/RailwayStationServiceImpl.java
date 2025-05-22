package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.RailwayStation;
import org.example.repository.RailwayStationRepository;
import org.example.service.RailwayStationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RailwayStationServiceImpl implements RailwayStationService {
    private final RailwayStationRepository repository;

    @Override
    public List<RailwayStation> findAll() {
        return repository.findAll();
    }

    public Optional<RailwayStation> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<RailwayStation> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(RailwayStation railwayStation) {
        repository.save(railwayStation);
    }

    @Override
    public void delete(RailwayStation railwayStation) {
        repository.delete(railwayStation);
    }


    @Override
    public void update(RailwayStation railwayStation, Long id) {
        repository.findById(id).ifPresent(existingRailwayStation -> {
            existingRailwayStation.setName(railwayStation.getName());
            existingRailwayStation.setRoads(railwayStation.getRoads());
            repository.save(existingRailwayStation);
        });
    }
}
