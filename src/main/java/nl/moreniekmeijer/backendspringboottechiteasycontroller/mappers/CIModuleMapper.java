package nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.CIModuleInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.CIModuleResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.CIModule;

public class CIModuleMapper {

    public static CIModule toEntity(CIModuleInputDto CIModuleInputDto) {
        CIModule cimodule = new CIModule();
        cimodule.setName(CIModuleInputDto.name);
        cimodule.setType(CIModuleInputDto.type);
        cimodule.setPrice(CIModuleInputDto.price);
        return cimodule;
    }

    public static CIModuleResponseDto toResponseDto(CIModule cimodule) {
        CIModuleResponseDto CIModuleResponseDto = new CIModuleResponseDto();
        CIModuleResponseDto.setId(cimodule.getId());
        CIModuleResponseDto.setName(cimodule.getName());
        CIModuleResponseDto.setType(cimodule.getType());
        CIModuleResponseDto.setPrice(cimodule.getPrice());
        return CIModuleResponseDto;
    }
}
