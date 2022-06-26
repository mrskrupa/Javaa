package practice.service.mapper;

import org.springframework.stereotype.Component;
import practice.model.Student;
import practice.model.dto.request.StudentRequestDto;
import practice.model.dto.response.StudentResponseDto;
import practice.service.DirectoryService;
import practice.service.SchoolService;

@Component
public class StudentDtoMapper {
    private final SchoolService schoolService;
    private final DirectoryService directoryService;

    public StudentDtoMapper(SchoolService schoolService, DirectoryService directoryService) {
        this.schoolService = schoolService;
        this.directoryService = directoryService;
    }

    public Student toModel(StudentRequestDto requestDto) {
        Student student = new Student();
        student.setAddress(requestDto.getAddress());
        student.setFirstName(requestDto.getFirstName());
        student.setLastName(requestDto.getLastName());
        student.setPatronymic(requestDto.getPatronymic());
        student.setPhoneNumber(requestDto.getPhoneNumber());
        student.setSchool(schoolService.get(requestDto.getSchoolId()));
        student.setDirectory(directoryService.get(requestDto.getDirectoryId()));
        return student;
    }

    public StudentResponseDto toDto(Student student) {
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setAddress(student.getAddress());
        responseDto.setFirstName(student.getFirstName());
        responseDto.setLastName(student.getLastName());
        responseDto.setPhoneNumber(student.getPhoneNumber());
        responseDto.setPatronymic(student.getPatronymic());
        responseDto.setSchoolId(student.getSchool().getId());
        responseDto.setDirectoryId(student.getDirectory().getId());
        return responseDto;
    }
}
