package nl.moreniekmeijer.backendspringboottechiteasycontroller.controllers;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.WallBracketInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.WallBracketResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.services.WallBracketService;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.utils.URIUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {
    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @PostMapping
    public ResponseEntity<WallBracketResponseDto> addWallBracket(@RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketResponseDto createdWallBracket = wallBracketService.addWallBracket(wallBracketInputDto);
        URI location = URIUtil.createResourceUri(createdWallBracket.getId());
        return ResponseEntity.created(location).body(createdWallBracket);
    }

    @GetMapping
    public ResponseEntity<List<WallBracketResponseDto>> getAllWallBrackets() {
        List<WallBracketResponseDto> foundWallBrackets = wallBracketService.getAllWallBrackets();
        return ResponseEntity.ok().body(foundWallBrackets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> getWallBracketById(@PathVariable Long id) {
        WallBracketResponseDto foundWallBracket = wallBracketService.getWallBracketById(id);
        return ResponseEntity.ok().body(foundWallBracket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketResponseDto updatedWallBracket = wallBracketService.updateWallBracket(id, wallBracketInputDto);
        return ResponseEntity.ok().body(updatedWallBracket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
}
