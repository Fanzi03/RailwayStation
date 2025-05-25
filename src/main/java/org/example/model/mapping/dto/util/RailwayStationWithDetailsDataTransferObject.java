package org.example.model.mapping.dto.util;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.Road;
import org.example.model.entity.Train;
import org.example.model.entity.enums.StatusOfRailwayStation;
import org.example.model.mapping.dto.RailwayStationDataTransferObject;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RailwayStationWithDetailsDataTransferObject extends RailwayStationDataTransferObject {
    Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 4, max = 250, message = "Name must be normal size")
    String name;
    @NotNull(message = "Free places are required")
    @Min(value = 0, message = "Free places must be positive")
    Integer freePlaces;
    @NotNull(message = "Status is required")
    StatusOfRailwayStation status;
    List<Road> roads;
    List<Train> trains;
}
