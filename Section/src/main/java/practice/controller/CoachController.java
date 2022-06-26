package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.model.Coach;
import practice.model.dto.request.CoachRequestDto;
import practice.service.CoachService;
import practice.service.mapper.CoachDtoMapper;
import java.util.List;

@Controller
public class CoachController {
    private final CoachService coachService;
    private final CoachDtoMapper dtoMapper;

    public CoachController(CoachService coachService,
                           CoachDtoMapper dtoMapper) {
        this.coachService = coachService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/coaches")
    public String findAll(Model model) {
        List<Coach> coaches = coachService.getAll();
        model.addAttribute("coaches", coaches);
        return "coaches";
    }

    @GetMapping("/coach-create")
    public String createCoachForm(CoachRequestDto requestDto) {
        return "coach-create";
    }

    @PostMapping("/coach-create")
    public String createCoach(CoachRequestDto requestDto) {
        Coach coach = dtoMapper.toModel(requestDto);
        coachService.add(coach);
        return "redirect:/coaches";
    }

    @GetMapping("/coach-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        coachService.delete(id);
        return "redirect:/coaches";
    }

    @GetMapping("/coach-update/{id}")
    public String updateCoachForm(@PathVariable("id") Long id, Model model) {
        Coach coach = coachService.get(id);
        model.addAttribute(coach);
        return "/coach-update";
    }

    @PostMapping("/coach-update")
    public String updateCoach(Coach coach) {
        coachService.add(coach);
        return "redirect:/coaches";
    }
}
