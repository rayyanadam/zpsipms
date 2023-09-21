package com.ict_project.ICT_PROJECT.controller;

import com.ict_project.ICT_PROJECT.model.SectorModel;
import com.ict_project.ICT_PROJECT.services.SectorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sector")
public class SectorController {
    private final SectorServices sectorServices;

    @PostMapping("/add")
    public ResponseEntity<?> saveSector(@RequestBody SectorModel request) {
        SectorModel response = sectorServices.saveSector(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<SectorModel>> getAllSector() {
        List<SectorModel> response = sectorServices.getAllSector();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSectorById(@PathVariable Long id){
        Optional<SectorModel> response = sectorServices.getSectorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SectorModel> updateSector(@PathVariable Long id, @RequestBody SectorModel sectorModel){
        SectorModel response = sectorServices.updateSector(id, sectorModel);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SectorModel> deleteSector(@PathVariable Long id) {
        SectorModel deletedSector = sectorServices.deleteSector(id);

        if (deletedSector != null) {
            return ResponseEntity.ok(deletedSector);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
