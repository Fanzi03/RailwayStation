package org.example.model.mapping.dto.util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.example.model.mapping.dto.RailwayStationDataTransferObject;
import org.example.model.mapping.dto.RoadDataTransferObject;
import org.example.model.mapping.dto.TrainDataTransferObject;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RailwayStationWithDetailsDataTransferObject extends RailwayStationDataTransferObject {
    List<RoadDataTransferObject> roads;
    List<TrainDataTransferObject> trains;
}
