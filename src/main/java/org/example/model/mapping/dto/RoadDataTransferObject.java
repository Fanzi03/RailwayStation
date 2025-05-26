package org.example.model.mapping.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.enums.StatusOfRoad;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoadDataTransferObject {
    Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 250, message = "Name must be normal size")
    String name;
    @NotNull(message = "Status of road is required")
    StatusOfRoad statusOfRoad;

}
