package practice.service.mapper;

import org.springframework.stereotype.Component;
import practice.model.Rank;
import practice.model.dto.request.RankRequestDto;
import practice.service.CoachService;

import java.util.stream.Collectors;

@Component
public class RankDtoMapper {
    private final CoachService coachService;

    public RankDtoMapper(CoachService coachService) {
        this.coachService = coachService;
    }

    public Rank toModel(RankRequestDto requestDto) {
        Rank rank = new Rank();
        rank.setRankType(requestDto.getRankType());
        return rank;
    }
}
