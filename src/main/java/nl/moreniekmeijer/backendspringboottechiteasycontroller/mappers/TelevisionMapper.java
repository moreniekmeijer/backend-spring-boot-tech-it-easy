package nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.TelevisionInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.TelevisionResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.TelevisionSalesInfoDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.Television;

import java.util.ArrayList;
import java.util.List;

public class TelevisionMapper {
    public static Television toEntity(TelevisionInputDto televisionInputDto) {
        Television television = new Television();
        television.setType(televisionInputDto.type);
        television.setBrand(televisionInputDto.brand);
        television.setName(televisionInputDto.name);
        television.setPrice(televisionInputDto.price);
        television.setAvailableSize(televisionInputDto.availableSize);
        television.setRefreshRate(televisionInputDto.refreshRate);
        television.setScreenType(televisionInputDto.screenType);
        television.setScreenQuality(televisionInputDto.screenQuality);
        television.setSmartTv(televisionInputDto.smartTv);
        television.setWifi(televisionInputDto.wifi);
        television.setVoiceControl(televisionInputDto.voiceControl);
        television.setHdr(televisionInputDto.hdr);
        television.setBluetooth(televisionInputDto.bluetooth);
        television.setAmbiLight(televisionInputDto.ambiLight);
        television.setOriginalStock(televisionInputDto.originalStock);
        television.setSold(televisionInputDto.sold);
        return television;
    }

    public static TelevisionResponseDto toResponseDto(Television television) {
        TelevisionResponseDto televisionResponseDto = new TelevisionResponseDto();
        televisionResponseDto.setId(television.getId());
        televisionResponseDto.setType(television.getType());
        televisionResponseDto.setBrand(television.getBrand());
        televisionResponseDto.setName(television.getName());
        televisionResponseDto.setPrice(television.getPrice());
        televisionResponseDto.setAvailableSize(television.getAvailableSize());
        televisionResponseDto.setRefreshRate(television.getRefreshRate());
        televisionResponseDto.setScreenType(television.getScreenType());
        televisionResponseDto.setScreenQuality(television.getScreenQuality());
        televisionResponseDto.setSmartTv(television.getSmartTv());
        televisionResponseDto.setWifi(television.getWifi());
        televisionResponseDto.setVoiceControl(television.getVoiceControl());
        televisionResponseDto.setHdr(television.getHdr());
        televisionResponseDto.setBluetooth(television.getBluetooth());
        televisionResponseDto.setAmbiLight(television.getAmbiLight());
        televisionResponseDto.setOriginalStock(television.getOriginalStock());
        televisionResponseDto.setSold(television.getSold());

        if (television.getRemoteController() != null) {
            televisionResponseDto.setRemoteController(RemoteControllerMapper.toResponseDto(television.getRemoteController()));
        }

        if (television.getCiModule() != null) {
            televisionResponseDto.setCiModule(CIModuleMapper.toResponseDto(television.getCiModule()));
        }

        if (television.getWallBrackets() != null) {
            televisionResponseDto.setWallBrackets(
                    television.getWallBrackets().stream()
                            .map(WallBracketMapper::toResponseDto)
                            .toList()
            );
        }

        return televisionResponseDto;
    }

    public static TelevisionSalesInfoDto toSalesInfoDto(Television television) {
        TelevisionSalesInfoDto televisionSalesInfoDto = new TelevisionSalesInfoDto();
        televisionSalesInfoDto.setId(television.getId());
        televisionSalesInfoDto.setPrice(television.getPrice());
        televisionSalesInfoDto.setOriginalStock(television.getOriginalStock());
        televisionSalesInfoDto.setSold(television.getSold());
        return televisionSalesInfoDto;
    }

    public static List<TelevisionResponseDto> toResponseDtoList(List<Television> televisions) {
        List<TelevisionResponseDto> televisionResponseDtoList = new ArrayList<>();
        for (Television television : televisions) {
            televisionResponseDtoList.add(toResponseDto(television));
        }
        return televisionResponseDtoList;
    }

    public static List<TelevisionSalesInfoDto> toSalesInfoDtoList(List<Television> televisions) {
        List<TelevisionSalesInfoDto> televisionSalesInfoDtoList = new ArrayList<>();
        for (Television television : televisions) {
            televisionSalesInfoDtoList.add(toSalesInfoDto(television));
        }
        return televisionSalesInfoDtoList;
    }
}
