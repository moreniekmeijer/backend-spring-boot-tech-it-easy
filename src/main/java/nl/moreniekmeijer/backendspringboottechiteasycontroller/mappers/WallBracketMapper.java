package nl.moreniekmeijer.backendspringboottechiteasycontroller.mappers;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.WallBracketInputDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.WallBracketResponseDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.WallBracket;

public class WallBracketMapper {

    public static WallBracket toEntity(WallBracketInputDto WallBracketInputDto) {
        WallBracket wallBracket = new WallBracket();
        wallBracket.setSize(WallBracketInputDto.size);
        wallBracket.setAdjustable(WallBracketInputDto.adjustable);
        wallBracket.setName(WallBracketInputDto.name);
        wallBracket.setPrice(WallBracketInputDto.price);
        return wallBracket;
    }

    public static WallBracketResponseDto toResponseDto(WallBracket wallBracket) {
        WallBracketResponseDto WallBracketResponseDto = new WallBracketResponseDto();
        WallBracketResponseDto.setId(wallBracket.getId());
        WallBracketResponseDto.setSize(wallBracket.getSize());
        WallBracketResponseDto.setAdjustable(wallBracket.getAdjustable());
        WallBracketResponseDto.setName(wallBracket.getName());
        WallBracketResponseDto.setPrice(wallBracket.getPrice());
        return WallBracketResponseDto;
    }
}
