package com.ict_project.ICT_PROJECT.services;

import com.ict_project.ICT_PROJECT.model.SectorModel;
import com.ict_project.ICT_PROJECT.repository.SectorRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class SectorServices {
    private final SectorRepository sectorRepository;

    public SectorModel saveSector(SectorModel sector) {
        return sectorRepository.save(sector);
    }

    public List<SectorModel> getAllSector() {
        return sectorRepository.findAll();
    }

    public Optional<SectorModel> getSectorById(Long id) {
        return sectorRepository.findById(id);
    }

    public SectorModel updateSector(Long id, SectorModel sectorModel) {
        Optional<SectorModel> optionalSector = sectorRepository.findById(id);
        if (optionalSector.isPresent()) {
            SectorModel existingSector = optionalSector.get();
            existingSector.setSectorName(sectorModel.getSectorName());
            existingSector.setSectorAddress(sectorModel.getSectorAddress());
            return sectorRepository.save(existingSector);
        } else {
            return null;
        }
    }

    public SectorModel deleteSector(Long id) {
        Optional<SectorModel> sectorToDelete = sectorRepository.findById(id);
        if (sectorToDelete.isPresent()) {
            sectorRepository.deleteById(id);
            return sectorToDelete.get();
        } else {
            return null;
        }
    }
}
