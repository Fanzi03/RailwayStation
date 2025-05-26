package org.example.model.mapping.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.enums.StatusOfTrain;
import org.example.enums.TypeOfTrain;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainDataTransferObject {
    Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 255, message = "Name must be normal size")
    String name;
    @NotNull(message = "Type of train is required")
    TypeOfTrain type;
    @NotNull(message = "Status of train is required")
    StatusOfTrain statusOfTrain;
    @NotBlank(message = "Version is required")
    @Size(min = 1, max = 2000, message = "Version must be normal size")
    String version;
    @NotNull(message = "Number is required")
    @Min(value = 59, message = "Number must be < 59symbols")
    Long number;
    String nameOfRoad;
    String nameOfStation;
}
