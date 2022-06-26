package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.model.School;
import practice.model.dto.request.SchoolRequestDto;
import practice.service.SchoolService;
import practice.service.mapper.SchoolDtoMapper;

import java.util.List;

@Controller
public class SchoolController {
    private final SchoolService schoolService;
    private final SchoolDtoMapper dtoMapper;

    public SchoolController(SchoolService schoolService,
                            SchoolDtoMapper dtoMapper) {
        this.schoolService = schoolService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/schools")
    public String findAll(Model model) {
        List<School> schools = schoolService.getAll();
        model.addAttribute("schools", schools);
        return "schools";
    }

    @GetMapping("/school-create")
    public String createSchoolForm(SchoolRequestDto requestDto) {
        return "school-create";
    }

    @PostMapping("/school-create")
    public String createSchool(SchoolRequestDto requestDto) {
        School school = dtoMapper.toModel(requestDto);
        schoolService.add(school);
        return "redirect:/schools";
    }

    @GetMapping("/school-delete/{id}")
    public String deleteSchool(@PathVariable("id") Long id) {
        schoolService.delete(id);
        return "redirect:/schools";
    }

    @GetMapping("/school-update/{id}")
    public String updateSchoolForm(@PathVariable("id") Long id, Model model) {
        School school = schoolService.get(id);
        model.addAttribute(school);
        return "/school-update";
    }

    @PostMapping("/school-update")
    public String updateSchool(School school) {
        schoolService.add(school);
        return "redirect:/schools";
    }
}
