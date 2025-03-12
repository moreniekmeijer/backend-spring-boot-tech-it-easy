package nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.RemoteControllerInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.RemoteControllerResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.RemoteController;

public class RemoteControllerMapper {

    public static RemoteController toEntity(RemoteControllerInputDto RemoteControllerInputDto) {
        RemoteController remoteController = new RemoteController();
        remoteController.setCompatibleWith(RemoteControllerInputDto.compatibleWith);
        remoteController.setBatteryType(RemoteControllerInputDto.batteryType);
        remoteController.setName(RemoteControllerInputDto.name);
        remoteController.setBrand(RemoteControllerInputDto.brand);
        remoteController.setPrice(RemoteControllerInputDto.price);
        remoteController.setOriginalStock(RemoteControllerInputDto.originalStock);
        return remoteController;
    }

    public static RemoteControllerResponseDto toResponseDto(RemoteController remoteController) {
        RemoteControllerResponseDto RemoteControllerResponseDto = new RemoteControllerResponseDto();
        RemoteControllerResponseDto.setId(remoteController.getId());
        RemoteControllerResponseDto.setCompatibleWith(remoteController.getCompatibleWith());
        RemoteControllerResponseDto.setBatteryType(remoteController.getBatteryType());
        RemoteControllerResponseDto.setName(remoteController.getName());
        RemoteControllerResponseDto.setBrand(remoteController.getBrand());
        RemoteControllerResponseDto.setPrice(remoteController.getPrice());
        RemoteControllerResponseDto.setOriginalStock(remoteController.getOriginalStock());
        return RemoteControllerResponseDto;
    }
}
