package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.enums.StatusOfTrain;
import org.example.enums.TypeOfTrain;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 55, nullable = false)
    TypeOfTrain type;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_train", length = 55, nullable = false)
    StatusOfTrain statusOfTrain;
    @Column(name = "version", nullable = false)
    String version;
    @Column(name = "number", unique = true, nullable = false)
    Long number;

    @ManyToOne(optional = true)
    @JoinColumn(name = "road_id")
    Road road;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "railway_station_id")
    RailwayStation railwayStation;
}
