package practice.service.mapper;

import org.springframework.stereotype.Component;
import practice.model.Directory;
import practice.model.dto.request.DirectoryRequestDto;

@Component
public class DirectoryDtoMapper {
    public Directory toModel(DirectoryRequestDto requestDto) {
        Directory directory = new Directory();
        directory.setTown(requestDto.getTown());
        directory.setArea(requestDto.getArea());
        return directory;
    }
}
