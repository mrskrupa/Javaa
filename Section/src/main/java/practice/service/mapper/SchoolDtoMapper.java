package practice.service.mapper;

import org.springframework.stereotype.Component;
import practice.model.School;
import practice.model.dto.request.SchoolRequestDto;

@Component
public class SchoolDtoMapper {
    public School toModel(SchoolRequestDto requestDto) {
        School school = new School();
        school.setSchoolName(requestDto.getSchoolName());
        school.setAddress(requestDto.getAddress());
        return school;
    }
}
