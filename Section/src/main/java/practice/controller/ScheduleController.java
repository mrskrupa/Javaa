package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.model.Schedule;
import practice.model.dto.request.ScheduleRequestDto;
import practice.model.dto.response.ScheduleResponseDto;
import practice.service.DirectoryService;
import practice.service.ScheduleService;
import practice.service.mapper.ScheduleDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleDtoMapper dtoMapper;
    private final DirectoryService directoryService;

    public ScheduleController(ScheduleService scheduleService,
                              ScheduleDtoMapper dtoMapper,
                              DirectoryService directoryService) {
        this.scheduleService = scheduleService;
        this.dtoMapper = dtoMapper;
        this.directoryService = directoryService;
    }

    @GetMapping("/schedules")
    public String findAll(Model model) {
        List<Schedule> all = scheduleService.getAll();
        List<ScheduleResponseDto> schedules = all.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("schedules", schedules);
        return "schedules";
    }

    @GetMapping("/schedule-create")
    public String createScheduleForm(ScheduleRequestDto requestDto) {
        return "schedule-create";
    }

    @PostMapping("/schedule-create")
    public String createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = dtoMapper.toModel(requestDto);
        scheduleService.add(schedule);
        return "redirect:/schedules";
    }

    @GetMapping("/schedule-delete/{id}")
    public String deleteSchedule(@PathVariable("id") Long id) {
        scheduleService.delete(id);
        return "redirect:/schedules";
    }

    @GetMapping("/schedule-update/{id}")
    public String updateScheduleForm(@PathVariable("id") Long id, Model model) {
        Schedule scheduleModel = scheduleService.get(id);
        ScheduleResponseDto schedule = dtoMapper.toDto(scheduleModel);
        model.addAttribute("schedule", schedule);
        return "/schedule-update";
    }

    @PostMapping("/schedule-update")
    public String updateSchedule(ScheduleResponseDto responseDto) {
        Schedule schedule = new Schedule();
        schedule.setId(responseDto.getId());
        schedule.setDirectory(directoryService.get(responseDto.getDirectoryId()));
        schedule.setBegin(responseDto.getBegin());
        schedule.setEnd(responseDto.getEnd());
        scheduleService.add(schedule);
        return "redirect:/schedules";
    }
}
