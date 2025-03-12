package nl.moreniekmeijer.backendspringboottechiteasycontroller.controllers;

import jakarta.validation.Valid;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.TelevisionInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.TelevisionResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.TelevisionSalesInfoDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers.TelevisionMapper;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.Television;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.services.TelevisionService;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.utils.URIUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @PostMapping
    public ResponseEntity<TelevisionResponseDto> addTelevision(@Valid @RequestBody TelevisionInputDto television) {
        Television savedTelevision = televisionService.saveTelevision(TelevisionMapper.toEntity(television));
        URI location = URIUtil.createResourceUri(savedTelevision.getId());
        return ResponseEntity.created(location).body(TelevisionMapper.toResponseDto(savedTelevision));
    }

    @GetMapping
    public ResponseEntity<List<TelevisionResponseDto>> getTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {
        List<Television> foundTelevisions = televisionService.getAllTelevisions(brand);
        return ResponseEntity.ok(TelevisionMapper.toResponseDtoList(foundTelevisions));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getTelevisionById(@PathVariable Long id) {
        return ResponseEntity.ok(TelevisionMapper.toResponseDto(televisionService.getTelevisionById(id)));
    }

    @GetMapping("/sales")
    public ResponseEntity<List<TelevisionSalesInfoDto>> getSalesInfoTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {
        List<Television> foundTelevisions = televisionService.getAllTelevisions(brand);
        return ResponseEntity.ok(TelevisionMapper.toSalesInfoDtoList(foundTelevisions));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto televisionDetails) {
        Television updatedTelevision = televisionService.updateTelevision(id, TelevisionMapper.toEntity(televisionDetails));
        return ResponseEntity.ok(TelevisionMapper.toResponseDto(updatedTelevision));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/remotecontrollers/{remoteControllerId}")
    public ResponseEntity<TelevisionResponseDto> assignRemoteControllerToTelevision(@PathVariable Long id, @PathVariable Long remoteControllerId) {
        TelevisionResponseDto updatedTelevision = televisionService.assignRemoteControllerToTelevision(id, remoteControllerId);
        return ResponseEntity.ok(updatedTelevision);
    }

    @PutMapping("/{id}/cimodules/{ciModulesId}")
    public ResponseEntity<TelevisionResponseDto> assignCIModuleToTelevision(@PathVariable Long id, @PathVariable Long ciModulesId) {
        TelevisionResponseDto updatedTelevision = televisionService.assignCIModuleToTelevision(id, ciModulesId);
        return ResponseEntity.ok(updatedTelevision);
    }

    @PutMapping("/{id}/wallbrackets/{wallBracketId}")
    public ResponseEntity<TelevisionResponseDto> assignWallBracketToTelevision(@PathVariable Long id, @PathVariable Long wallBracketId) {
        TelevisionResponseDto updatedTelevision = televisionService.assignWallBracketToTelevision(id, wallBracketId);
        return ResponseEntity.ok(updatedTelevision);
    }
}
