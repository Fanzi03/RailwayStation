package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.enums.StatusOfRailwayStation;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(exclude = "trains")
public class RailwayStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @ManyToMany(mappedBy = "railwayStations", fetch = FetchType.LAZY)
    List<Road> roads;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_station")
    StatusOfRailwayStation statusOfRailwayStation;
    @Column(name = "free_places")
    int freePlaces;

    @OneToMany(mappedBy = "railwayStation", fetch = FetchType.LAZY)
    List<Train> trains;
}
