package org.example.service.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.mapping.dto.util.RoadWithDetailsDataTransferObject;
import org.example.model.mapping.mappers.RoadMapper;
import org.example.repository.RoadRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoadWithDetailsService {
    RoadRepository roadRepository;
    RoadMapper roadMapper;

    public RoadWithDetailsDataTransferObject getRoadWithDetails(Long roadId) {
        return roadMapper.toDTOWithDetails(
                roadRepository.findById(roadId)
                        .orElseThrow(() -> new NoSuchElementException("Road with id " + roadId + " not found")
        ));
    }
}
