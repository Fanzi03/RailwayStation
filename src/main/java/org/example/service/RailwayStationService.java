package org.example.service;

import org.example.model.entity.RailwayStation;
import org.example.model.mapping.dto.RailwayStationDataTransferObject;
import org.example.model.mapping.dto.util.RailwayStationWithDetailsDataTransferObject;


import java.util.List;

public interface RailwayStationService {
    RailwayStationWithDetailsDataTransferObject getRailwayStationWithDetails(Long stationId);
    List<RailwayStationDataTransferObject> findAll();
    RailwayStationDataTransferObject findByName(String name);
    RailwayStation findEntityByName(String name);
    void save(RailwayStationDataTransferObject railwayStationDataTransferObject);
    void delete(Long stationId);
    void update(RailwayStationDataTransferObject railwayStationDataTransferObject, Long id);
    RailwayStationDataTransferObject findById(Long id);
}
