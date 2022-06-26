package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.model.Student;
import practice.model.dto.request.StudentRequestDto;
import practice.model.dto.response.StudentResponseDto;
import practice.service.DirectoryService;
import practice.service.SchoolService;
import practice.service.StudentService;
import practice.service.mapper.StudentDtoMapper;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final StudentDtoMapper dtoMapper;
    private final DirectoryService directoryService;
    private final SchoolService schoolService;

    public StudentController(StudentService studentService,
                             StudentDtoMapper dtoMapper,
                             DirectoryService directoryService,
                             SchoolService schoolService) {
        this.studentService = studentService;
        this.dtoMapper = dtoMapper;
        this.directoryService = directoryService;
        this.schoolService = schoolService;
    }

    @GetMapping("/students")
    public String findAll(Model model) {
        List<Student> all = studentService.getAll();
        List<StudentResponseDto> students = all.stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/student-create")
    public String createStudentForm(StudentRequestDto requestDto) {
        return "student-create";
    }

    @PostMapping("/student-create")
    public String createStudent(StudentRequestDto requestDto) {
        Student student = dtoMapper.toModel(requestDto);
        studentService.add(student);
        return "redirect:/students";
    }

    @GetMapping("/student-delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/student-update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model) {
        Student studentModel = studentService.get(id);
        StudentResponseDto student = dtoMapper.toDto(studentModel);
        model.addAttribute("student", student);
        return "/student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(StudentResponseDto responseDto) {
        Student student = new Student();
        student.setId(responseDto.getId());
        student.setDirectory(directoryService.get(responseDto.getDirectoryId()));
        student.setSchool(schoolService.get(responseDto.getSchoolId()));
        student.setPatronymic(responseDto.getPatronymic());
        student.setAddress(responseDto.getAddress());
        student.setFirstName(responseDto.getFirstName());
        student.setLastName(responseDto.getLastName());
        student.setPhoneNumber(responseDto.getPhoneNumber());
        studentService.add(student);
        return "redirect:/students";
    }
}
