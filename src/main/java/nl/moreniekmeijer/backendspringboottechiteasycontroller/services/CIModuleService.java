package nl.moreniekmeijer.backendspringboottechiteasycontroller.services;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.CIModuleInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.CIModuleResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.exceptions.IndexOutOfBoundsException;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers.CIModuleMapper;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.CIModule;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CIModuleService {
    public final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public CIModuleResponseDto addCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule createdCIModule = ciModuleRepository.save(CIModuleMapper.toEntity(ciModuleInputDto));
        return CIModuleMapper.toResponseDto(createdCIModule);
    }

    public List<CIModuleResponseDto> getAllCIModules() {
        List<CIModule> foundCIModules = ciModuleRepository.findAll();
        return foundCIModules.stream()
                .map(CIModuleMapper::toResponseDto)
                .toList();
    }

    public CIModuleResponseDto getCIModuleById(Long id) {
        if (id < 0) {
            throw new IndexOutOfBoundsException("ID cannot be negative: " + id);
        }

        CIModule foundCIModule = ciModuleRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("CIModule with ID " + id + " not found."));
        return CIModuleMapper.toResponseDto(foundCIModule);
    }

    public CIModuleResponseDto updateCIModule(Long id, CIModuleInputDto ciModuleInputDto) {
        CIModule foundCIModule = ciModuleRepository.findById(id)
                .map(existingCIModule -> {
                    existingCIModule.setName(ciModuleInputDto.name);
                    existingCIModule.setPrice(ciModuleInputDto.price);
                    existingCIModule.setType(ciModuleInputDto.type);
                    return ciModuleRepository.save(existingCIModule);
                })
                .orElseThrow(() -> new RecordNotFoundException("CIModule with ID " + id + " not found."));

        return CIModuleMapper.toResponseDto(foundCIModule);
    }

    public void deleteCIModule(Long id) {
        if (id < 0) {
            throw new IndexOutOfBoundsException("ID cannot be negative: " + id);
        }

        CIModule foundCIModule = ciModuleRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("CIModule with ID " + id + " not found."));

        ciModuleRepository.delete(foundCIModule);
    }
}
