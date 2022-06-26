package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.model.Unit;
import practice.model.dto.request.UnitRequestDto;
import practice.model.dto.response.UnitResponseDto;
import practice.service.DirectoryService;
import practice.service.UnitService;
import practice.service.mapper.UnitDtoMapper;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UnitController {
    private final UnitService unitService;
    private final UnitDtoMapper dtoMapper;
    private final DirectoryService directoryService;

    public UnitController(UnitService unitService,
                          UnitDtoMapper dtoMapper,
                          DirectoryService directoryService) {
        this.unitService = unitService;
        this.dtoMapper = dtoMapper;
        this.directoryService = directoryService;
    }

    @GetMapping("/units")
    public String findAll(Model model) {
        List<Unit> unitsModel = unitService.getAll();
        List<UnitResponseDto> units = unitsModel.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("units", units);
        return "units";
    }

    @GetMapping("/unit-create")
    public String createUnitForm(UnitRequestDto requestDto) {
        return "unit-create";
    }

    @PostMapping("/unit-create")
    public String createUnit(UnitRequestDto requestDto) {
        Unit unit = dtoMapper.toModel(requestDto);
        unitService.add(unit);
        return "redirect:/units";
    }

    @GetMapping("/unit-delete/{id}")
    public String deleteUnit(@PathVariable("id") Long id) {
        unitService.delete(id);
        return "redirect:/units";
    }

    @GetMapping("/unit-update/{id}")
    public String updateUnitForm(@PathVariable("id") Long id, Model model) {
        Unit unitModel = unitService.get(id);
        UnitResponseDto unit = dtoMapper.toDto(unitModel);
        model.addAttribute("unit", unit);
        return "/unit-update";
    }

    @PostMapping("/unit-update")
    public String updateUnit(UnitResponseDto responseDto) {
        Unit unit = new Unit();
        unit.setId(responseDto.getId());
        unit.setDirectory(directoryService.get(responseDto.getDirectoryId()));
        unit.setSectionName(responseDto.getSectionName());
        unitService.add(unit);
        return "redirect:/units";
    }
}
