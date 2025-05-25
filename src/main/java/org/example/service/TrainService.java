package org.example.service;

import org.example.model.entity.Train;
import org.example.model.mapping.dto.TrainDataTransferObject;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TrainService {
    List<TrainDataTransferObject> findAll();
    TrainDataTransferObject findByNumber(Long number);
    void save(TrainDataTransferObject trainDataTransferObject);
    void delete(Long id);
    void update(TrainDataTransferObject train, Long id);
    TrainDataTransferObject findById(Long id);
}
