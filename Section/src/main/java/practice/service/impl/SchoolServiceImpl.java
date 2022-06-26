package practice.service.impl;

import org.springframework.stereotype.Service;
import practice.repository.SchoolDao;
import practice.model.School;
import practice.service.SchoolService;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    private final SchoolDao schoolDao;

    public SchoolServiceImpl(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public School add(School school) {
        return schoolDao.save(school);
    }

    @Override
    public School get(Long id) {
        return schoolDao.findById(id).orElseThrow(() ->
                new RuntimeException("Invalid input id: " + id));
    }

    @Override
    public List<School> getAll() {
        return schoolDao.findAll();
    }

    @Override
    public void delete(Long id) {
        schoolDao.deleteById(id);
    }
}
