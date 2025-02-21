package nl.moreniekmeijer.backendspringboottechiteasycontroller.services;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.Television;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.repositories.TelevisionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public Television saveTelevision(Television television) {
        return televisionRepository.save(television);
    }

    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Television getTelevisionById(Long id) {
        return televisionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Television with ID " + id + " not found."));
    }

    // alternative
    public Optional<Television> getTelevisionById2(Long id) {
        return televisionRepository.findById(id);
    }

    public Television updateTelevision(Long id, Television televisionDetails) {
        return televisionRepository.findById(id)
                .map(existingTelevision -> {
                    existingTelevision.setName(televisionDetails.getName());
                    existingTelevision.setPrice(televisionDetails.getPrice());
                    existingTelevision.setBrand(televisionDetails.getBrand());
                    return televisionRepository.save(existingTelevision);
                })
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));
    }

    public void deleteTelevision(Long id) {
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("Television with ID " + id + " not found");
        }
        televisionRepository.deleteById(id);
    }
}
