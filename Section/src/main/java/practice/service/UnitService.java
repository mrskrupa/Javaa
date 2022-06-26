package practice.service;

import practice.model.Unit;

import java.util.List;

public interface UnitService {
    Unit add(Unit section);

    Unit get(Long id);

    List<Unit> getAll();

    void delete(Long id);
}
