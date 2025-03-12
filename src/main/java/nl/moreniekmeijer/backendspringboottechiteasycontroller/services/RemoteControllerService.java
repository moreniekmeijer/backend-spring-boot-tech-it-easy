package nl.moreniekmeijer.backendspringboottechiteasycontroller.services;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.RemoteControllerInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.RemoteControllerResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers.RemoteControllerMapper;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.RemoteController;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public RemoteControllerResponseDto addRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController createdRemoteController = remoteControllerRepository.save(RemoteControllerMapper.toEntity(remoteControllerInputDto));
        return RemoteControllerMapper.toResponseDto(createdRemoteController);
    }

    public List<RemoteControllerResponseDto> getAllRemoteControllers() {
        List<RemoteController> foundRemoteControllers = remoteControllerRepository.findAll();
        return foundRemoteControllers.stream()
                .map(RemoteControllerMapper::toResponseDto)
                .toList();
    }

    public RemoteControllerResponseDto getRemoteControllerById(Long id) {
        if (id < 0) {
            throw new IndexOutOfBoundsException("ID cannot be negative: " + id);
        }

        RemoteController foundRemoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController with ID " + id + " not found."));
        return RemoteControllerMapper.toResponseDto(foundRemoteController);
    }

    public RemoteControllerResponseDto updateRemoteController(Long id, RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController foundRemoteController = remoteControllerRepository.findById(id)
                .map(existingRemoteController -> {
                    existingRemoteController.setCompatibleWith(remoteControllerInputDto.compatibleWith);
                    existingRemoteController.setBatteryType(remoteControllerInputDto.batteryType);
                    existingRemoteController.setName(remoteControllerInputDto.name);
                    existingRemoteController.setBrand(remoteControllerInputDto.brand);
                    existingRemoteController.setPrice(remoteControllerInputDto.price);
                    existingRemoteController.setOriginalStock(remoteControllerInputDto.originalStock);
                    return remoteControllerRepository.save(existingRemoteController);
                })
                .orElseThrow(() -> new RecordNotFoundException("RemoteController with ID " + id + " not found."));

        return RemoteControllerMapper.toResponseDto(foundRemoteController);
    }

    public void deleteRemoteController(Long id) {
        if (id < 0) {
            throw new IndexOutOfBoundsException("ID cannot be negative: " + id);
        }

        RemoteController foundRemoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController with ID " + id + " not found."));

        remoteControllerRepository.delete(foundRemoteController);
    }
}
