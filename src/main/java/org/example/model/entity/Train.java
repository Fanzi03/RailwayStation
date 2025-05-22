package org.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.enums.StatusOfTrain;
import org.example.model.entity.enums.TypeOfTrain;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    TypeOfTrain type;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_train")
    StatusOfTrain statusOfTrain;
    @Column(name = "version")
    String version;
    @Column(name = "number", unique = true)
    long number;

    @ManyToOne(optional = true)
    @JoinColumn(name = "road_id")
    Road road;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "railway_station_id")
    RailwayStation railwayStation;
}
