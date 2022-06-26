package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.model.Rank;
import practice.model.dto.request.RankRequestDto;
import practice.service.RankService;
import practice.service.mapper.RankDtoMapper;

import java.util.List;

@Controller
public class RankController {
    private final RankService rankService;
    private final RankDtoMapper dtoMapper;

    public RankController(RankService rankService,
                          RankDtoMapper dtoMapper) {
        this.rankService = rankService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/ranks")
    public String findAll(Model model) {
        List<Rank> ranks = rankService.getAll();
        model.addAttribute("ranks", ranks);
        return "ranks";
    }

    @GetMapping("/rank-create")
    public String createRankForm(RankRequestDto requestDto) {
        return "rank-create";
    }

    @PostMapping("/rank-create")
    public String createRank(RankRequestDto requestDto) {
        Rank rank = dtoMapper.toModel(requestDto);
        rankService.add(rank);
        return "redirect:/ranks";
    }

    @GetMapping("/rank-delete/{id}")
    public String deleteRank(@PathVariable("id") Long id) {
        rankService.delete(id);
        return "redirect:/ranks";
    }

    @GetMapping("/rank-update/{id}")
    public String updateRankForm(@PathVariable("id") Long id, Model model) {
        Rank rank = rankService.get(id);
        model.addAttribute(rank);
        return "/rank-update";
    }

    @PostMapping("/rank-update")
    public String updateRank(Rank rank) {
        rankService.add(rank);
        return "redirect:/ranks";
    }
}
