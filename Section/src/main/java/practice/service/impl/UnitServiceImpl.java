package practice.service.impl;

import org.springframework.stereotype.Service;
import practice.model.Unit;
import practice.repository.UnitDao;
import practice.service.UnitService;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    private final UnitDao unitDao;

    public UnitServiceImpl(UnitDao unitDao) {
        this.unitDao = unitDao;
    }

    @Override
    public Unit add(Unit section) {
        return unitDao.save(section);
    }

    @Override
    public Unit get(Long id) {
        return unitDao.findById(id).orElseThrow(() ->
                new RuntimeException("Invalid input id: " + id));
    }

    @Override
    public List<Unit> getAll() {
        return unitDao.findAll();
    }

    @Override
    public void delete(Long id) {
        unitDao.deleteById(id);
    }
}
