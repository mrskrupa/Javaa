package practice.service.mapper;

import org.springframework.stereotype.Component;
import practice.model.Schedule;
import practice.model.dto.request.ScheduleRequestDto;
import practice.model.dto.response.ScheduleResponseDto;
import practice.service.DirectoryService;

@Component
public class ScheduleDtoMapper {
    private final DirectoryService directoryService;

    public ScheduleDtoMapper(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    public ScheduleResponseDto toDto(Schedule schedule) {
        ScheduleResponseDto responseDto = new ScheduleResponseDto();
        responseDto.setId(schedule.getId());
        responseDto.setDirectoryId(schedule.getDirectory().getId());
        responseDto.setBegin(schedule.getBegin());
        responseDto.setEnd(schedule.getEnd());
        return responseDto;
    }
    public Schedule toModel(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule();
        schedule.setEnd(requestDto.getEnd());
        schedule.setBegin(requestDto.getBegin());
        schedule.setDirectory(directoryService.get(requestDto.getDirectoryId()));
        return schedule;
    }
}
