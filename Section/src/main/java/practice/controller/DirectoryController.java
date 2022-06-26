package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.model.Directory;
import practice.model.dto.request.DirectoryRequestDto;
import practice.service.DirectoryService;
import practice.service.mapper.DirectoryDtoMapper;

import java.util.List;

@Controller
public class DirectoryController {
    private final DirectoryService directoryService;
    private final DirectoryDtoMapper dtoMapper;

    public DirectoryController(DirectoryService directoryService,
                               DirectoryDtoMapper dtoMapper) {
        this.directoryService = directoryService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/directories")
    public String findAll(Model model) {
        List<Directory> directories = directoryService.getAll();
        model.addAttribute("directories", directories);
        return "directories";
    }

    @GetMapping("/directory-create")
    public String createDirectoryForm(DirectoryRequestDto requestDto) {
        return "directory-create";
    }

    @PostMapping("/directory-create")
    public String createDirectory(DirectoryRequestDto requestDto) {
        Directory directory = dtoMapper.toModel(requestDto);
        directoryService.add(directory);
        return "redirect:/directories";
    }

    @GetMapping("/directory-delete/{id}")
    public String deleteDirectory(@PathVariable("id") Long id) {
        directoryService.delete(id);
        return "redirect:/directories";
    }

    @GetMapping("/directory-update/{id}")
    public String updateDirectoryForm(@PathVariable("id") Long id, Model model) {
        Directory directory = directoryService.get(id);
        model.addAttribute(directory);
        return "/directory-update";
    }

    @PostMapping("/directory-update")
    public String updateDirectory(Directory directory) {
        directoryService.add(directory);
        return "redirect:/directories";
    }
}
