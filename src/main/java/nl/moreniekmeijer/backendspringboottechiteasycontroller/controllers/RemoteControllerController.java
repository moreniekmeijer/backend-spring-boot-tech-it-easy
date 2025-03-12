package nl.moreniekmeijer.backendspringboottechiteasycontroller.controllers;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.RemoteControllerInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.RemoteControllerResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {
    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @PostMapping
    public ResponseEntity<RemoteControllerResponseDto> addRemoteController(@RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerResponseDto createdRemoteController = remoteControllerService.addRemoteController(remoteControllerInputDto);
        return ResponseEntity.created(null).body(createdRemoteController);
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerResponseDto>> getAllRemoteControllers() {
        List<RemoteControllerResponseDto> foundRemoteControllers = remoteControllerService.getAllRemoteControllers();
        return ResponseEntity.ok().body(foundRemoteControllers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> getRemoteControllerById(@PathVariable Long id) {
        RemoteControllerResponseDto foundRemoteController = remoteControllerService.getRemoteControllerById(id);
        return ResponseEntity.ok().body(foundRemoteController);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> updateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerResponseDto updatedRemoteController = remoteControllerService.updateRemoteController(id, remoteControllerInputDto);
        return ResponseEntity.ok().body(updatedRemoteController);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);
        return ResponseEntity.noContent().build();
    }
}
