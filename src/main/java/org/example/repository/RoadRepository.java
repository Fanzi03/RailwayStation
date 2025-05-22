package org.example.repository;

import org.example.model.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoadRepository extends JpaRepository<Road, Long> {
    Optional<Road> findByName(String name);
}
