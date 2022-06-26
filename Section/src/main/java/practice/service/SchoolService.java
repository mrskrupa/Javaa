package practice.service;

import practice.model.School;

import java.util.List;

public interface SchoolService {
    School add(School school);

    School get(Long id);

    List<School> getAll();

    void delete(Long id);
}
