package org.example.model.mapping.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.enums.StatusOfRailwayStation;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RailwayStationDataTransferObject {
    Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 4, max = 250, message = "name must be normal size")
    String name;
    @NotNull(message = "Free places are required")
    @Min(value = 0, message = "Free places must be positive")
    Long freePlaces;
    @NotNull(message = "Status of station is required")
    StatusOfRailwayStation statusOfRailwayStation;
}
