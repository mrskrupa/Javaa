package practice.service.mapper;

import org.springframework.stereotype.Component;
import practice.model.Coach;
import practice.model.dto.request.CoachRequestDto;
import practice.service.RankService;

@Component
public class CoachDtoMapper {
    private final RankService rankService;

    public CoachDtoMapper(RankService rankService) {
        this.rankService = rankService;
    }

    public Coach toModel(CoachRequestDto requestDto) {
        Coach coach = new Coach();
        coach.setFirstName(requestDto.getFirstName());
        coach.setLastName(requestDto.getLastName());
        coach.setPatronymic(requestDto.getPatronymic());
        return coach;
    }
}
