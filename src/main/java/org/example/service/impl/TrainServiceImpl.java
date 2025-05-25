package org.example.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.Train;
import org.example.model.mapping.dto.TrainDataTransferObject;
import org.example.model.mapping.mappers.TrainMapper;
import org.example.repository.TrainRepository;
import org.example.service.RailwayStationService;
import org.example.service.RoadService;
import org.example.service.TrainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrainServiceImpl implements TrainService {
    TrainRepository trainRepository;
    TrainMapper trainMapper;
    RoadService roadService;
    RailwayStationService railwayStationService;


    @Override
    public List<TrainDataTransferObject> findAll() {
        return trainRepository.findAll().stream().map(trainMapper::toDTO).toList();
    }

    @Override
    public TrainDataTransferObject findByNumber(Long number) {
        return trainMapper.toDTO(trainRepository.findByNumber(number)
                .orElseThrow(() -> new NoSuchElementException("Train with number " + number + " not found"))
        );
    }

    @Override
    public void save(TrainDataTransferObject trainDataTransferObject) {
        trainRepository.save(trainMapper.toEntity(trainDataTransferObject, roadService, railwayStationService));
    }

    @Override
    public void delete(Long id) {
        trainRepository.deleteById(id);
    }

    @Override
    public void update(TrainDataTransferObject trainDataTransferObject, Long id) {
        trainRepository.findById(id).ifPresent(
                existingTrain -> {
                    Train train = trainMapper.toEntity(trainDataTransferObject, roadService, railwayStationService);
                    train.setStatusOfTrain(existingTrain.getStatusOfTrain());
                    train.setRailwayStation(existingTrain.getRailwayStation());
                    train.setName(existingTrain.getName());
                    train.setType(existingTrain.getType());
                    trainRepository.save(train);
        });
    }

    @Override
    public TrainDataTransferObject findById(Long id) {
        return trainMapper.toDTO(trainRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("Train with id " + id + "not found")
        ));
    }
}
