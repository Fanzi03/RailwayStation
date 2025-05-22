package org.example.service;

import org.example.model.entity.Train;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainService {
    List<Train> findAll();
    Train findByNumber(Long number);
    void save(Train train);
    void delete(Long number);
    void update(Train train, Long number);
}
