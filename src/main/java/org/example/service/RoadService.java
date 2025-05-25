package org.example.service;

import org.example.model.entity.Road;
import org.example.model.mapping.dto.RoadDataTransferObject;
import org.example.model.mapping.dto.util.RoadWithDetailsDataTransferObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoadService {
    RoadWithDetailsDataTransferObject getRoadWithDetails(Long roadId);
    List<RoadDataTransferObject> findAll();
    RoadDataTransferObject findByName(String name);
    void save(RoadDataTransferObject roadDataTransferObject);
    void delete(Long id);
    void update(RoadDataTransferObject roadDataTransferObject, Long id);
    RoadDataTransferObject findById(Long id);
}
