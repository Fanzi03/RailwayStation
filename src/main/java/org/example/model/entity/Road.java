package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.enums.StatusOfRoad;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_road", length = 55, nullable = false)
    StatusOfRoad statusOfRoad;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "road_station",
            joinColumns = @JoinColumn(name = "road_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    List<RailwayStation> railwayStations;

}
