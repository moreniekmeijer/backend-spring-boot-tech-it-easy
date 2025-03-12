package nl.moreniekmeijer.backendspringboottechiteasycontroller.services;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.WallBracketInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.WallBracketResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers.WallBracketMapper;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.WallBracket;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallBracketService {
    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public WallBracketResponseDto addWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket createdWallBracket = wallBracketRepository.save(WallBracketMapper.toEntity(wallBracketInputDto));
        return WallBracketMapper.toResponseDto(createdWallBracket);
    }

    public List<WallBracketResponseDto> getAllWallBrackets() {
        List<WallBracket> foundWallBrackets = wallBracketRepository.findAll();
        return foundWallBrackets.stream()
                .map(WallBracketMapper::toResponseDto)
                .toList();
    }

    public WallBracketResponseDto getWallBracketById(Long id) {
        if (id < 0) {
            throw new IndexOutOfBoundsException("ID cannot be negative: " + id);
        }

        WallBracket foundWallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket with ID " + id + " not found."));
        return WallBracketMapper.toResponseDto(foundWallBracket);
    }

    public WallBracketResponseDto updateWallBracket(Long id, WallBracketInputDto wallBracketInputDto) {
        WallBracket foundWallBracket = wallBracketRepository.findById(id)
                .map(existingWallBracket -> {
                    existingWallBracket.setSize(wallBracketInputDto.size);
                    existingWallBracket.setAdjustable(wallBracketInputDto.adjustable);
                    existingWallBracket.setName(wallBracketInputDto.name);
                    existingWallBracket.setPrice(wallBracketInputDto.price);
                    return wallBracketRepository.save(existingWallBracket);
                })
                .orElseThrow(() -> new RecordNotFoundException("WallBracket with ID " + id + " not found."));

        return WallBracketMapper.toResponseDto(foundWallBracket);
    }

    public void deleteWallBracket(Long id) {
        if (id < 0) {
            throw new IndexOutOfBoundsException("ID cannot be negative: " + id);
        }

        WallBracket foundWallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket with ID " + id + " not found."));

        wallBracketRepository.delete(foundWallBracket);
    }
}
