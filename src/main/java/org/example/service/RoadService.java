package org.example.service;

import org.example.model.entity.Road;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoadService {
    List<Road> findALl();
    Road findByName(String name);
    void save(Road road);
    void delete(Road road);
    void update(Road road);
    Road findById(Long id);
}
