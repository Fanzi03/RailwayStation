package org.example.repository;

import org.example.model.entity.Train;
import org.example.model.mapping.dto.TrainDataTransferObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Optional<Train> findByNumber(long number);
}
