package nl.moreniekmeijer.backendspringboottechiteasycontroller.controllers;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.CIModuleInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.CIModuleResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.services.CIModuleService;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.utils.URIUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cimodules")
public class CIModuleController {
    public final CIModuleService ciModuleService;

    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @PostMapping
    public ResponseEntity<CIModuleResponseDto> addCIModule(@RequestBody CIModuleInputDto ciModuleInputDto) {
        CIModuleResponseDto createdCIModule = ciModuleService.addCIModule(ciModuleInputDto);
        URI location = URIUtil.createResourceUri(createdCIModule.getId());
        return ResponseEntity.created(location).body(createdCIModule);
    }

    @GetMapping
    public ResponseEntity<List<CIModuleResponseDto>> getAllCIModules() {
        List<CIModuleResponseDto> foundCIModules = ciModuleService.getAllCIModules();
        return ResponseEntity.ok().body(foundCIModules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CIModuleResponseDto> getCIModuleById(@PathVariable Long id) {
        CIModuleResponseDto foundCIModule = ciModuleService.getCIModuleById(id);
        return ResponseEntity.ok().body(foundCIModule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CIModuleResponseDto> updateCIModule(@PathVariable Long id, @RequestBody CIModuleInputDto ciModuleInputDto) {
        CIModuleResponseDto updatedCIModule = ciModuleService.updateCIModule(id, ciModuleInputDto);
        return ResponseEntity.ok().body(updatedCIModule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCIModule(@PathVariable Long id) {
        ciModuleService.deleteCIModule(id);
        return ResponseEntity.noContent().build();
    }
}
