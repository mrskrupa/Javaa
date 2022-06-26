package practice.service.impl;

import org.springframework.stereotype.Service;
import practice.repository.StudentDao;
import practice.model.Student;
import practice.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student add(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student get(Long id) {
        return studentDao.findById(id).orElseThrow(() ->
                new RuntimeException("Invalid input id: " + id));
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }

    @Override
    public void delete(Long id) {
        studentDao.deleteById(id);
    }
}
