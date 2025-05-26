package org.example.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.mapping.dto.RailwayStationDataTransferObject;
import org.example.model.mapping.dto.util.RailwayStationWithDetailsDataTransferObject;
import org.example.service.RailwayStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/railwayStation")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RailwayStationController {
    RailwayStationService railwayStationService;

    @GetMapping
    public List<RailwayStationDataTransferObject> getAllStations(){
        return railwayStationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RailwayStationDataTransferObject> getStationById(@PathVariable Long id){
        return ResponseEntity.ok(railwayStationService.findById(id));
    }

    @GetMapping("/{id}/withInfo")
    public ResponseEntity<RailwayStationWithDetailsDataTransferObject> getStationWithInfoById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(railwayStationService.getRailwayStationWithDetails(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveStation(
            @RequestBody @Valid RailwayStationDataTransferObject railwayStationDataTransferObject
    ){
        railwayStationService.save(railwayStationDataTransferObject);
       return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateStation(
            @RequestBody @Valid RailwayStationDataTransferObject railwayStationDataTransferObject, Long id
    ){
        railwayStationService.update(railwayStationDataTransferObject, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id){
        railwayStationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
