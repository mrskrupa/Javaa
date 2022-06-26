package practice.service;

import practice.model.Student;

import java.util.List;

public interface StudentService {
    Student add(Student student);

    Student get(Long id);

    List<Student> getAll();

    void delete(Long id);
}
