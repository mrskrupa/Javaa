package practice.service.mapper;

import org.springframework.stereotype.Component;
import practice.model.Unit;
import practice.model.dto.request.UnitRequestDto;
import practice.model.dto.response.UnitResponseDto;
import practice.service.DirectoryService;

@Component
public class UnitDtoMapper {
    private final DirectoryService directoryService;

    public UnitDtoMapper(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    public UnitResponseDto toDto(Unit unit) {
        UnitResponseDto responseDto = new UnitResponseDto();
        responseDto.setId(unit.getId());
        responseDto.setSectionName(unit.getSectionName());
        responseDto.setDirectoryId(unit.getDirectory().getId());
        return responseDto;
    }

    public Unit toModel(UnitRequestDto requestDto) {
        Unit unit = new Unit();
        unit.setSectionName(requestDto.getSectionName());
        unit.setDirectory(directoryService.get(requestDto.getDirectoryId()));
        return unit;
    }
}
