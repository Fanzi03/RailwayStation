package org.example.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.Road;
import org.example.model.mapping.dto.RoadDataTransferObject;
import org.example.model.mapping.dto.util.RoadWithDetailsDataTransferObject;
import org.example.model.mapping.mappers.RoadMapper;
import org.example.repository.RoadRepository;
import org.example.service.RoadService;
import org.example.service.util.RoadWithDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoadServiceImpl implements RoadService {
    RoadRepository roadRepository;
    RoadMapper roadMapper;
    RoadWithDetailsService roadWithDetailsService;

    public void save(RoadDataTransferObject roadDataTransferObject) {
        roadRepository.save(roadMapper.toEntity(roadDataTransferObject));
    }

    @Override
    public RoadWithDetailsDataTransferObject getRoadWithDetails(Long roadId) {
        return roadWithDetailsService.getRoadWithDetails(roadId);
    }

    @Override
    public List<RoadDataTransferObject> findAll() {
        return roadRepository.findAll().stream().map(roadMapper::toDTO).toList();
    }

    @Override
    public RoadDataTransferObject findByName(String name) {
        return roadMapper.toDTO(
                roadRepository.findByName(name)
                        .orElseThrow(() -> new NoSuchElementException("Road with name " + name + " not found"))
        );
    }

    @Override
    public Road findEntityByName(String name) {
        return roadRepository.findByName(name).orElseThrow(
                () -> new NoSuchElementException("Road with name " + name + " not found")
        );
    }

    @Override
    public void delete(Long id) {
        roadRepository.deleteById(id);
    }

    @Override
    public void update(RoadDataTransferObject roadDataTransferObject, Long id) {
        roadRepository.findById(id).ifPresent(
                existingRoad -> {
                    Road road = roadMapper.toEntity(roadDataTransferObject);
                    existingRoad.setStatusOfRoad(road.getStatusOfRoad());
                    roadRepository.save(existingRoad);
                }
        );
    }

    @Override
    public RoadDataTransferObject findById(Long id) {
        return roadMapper.toDTO(roadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Road with id " + id + " not found")));
    }
}
