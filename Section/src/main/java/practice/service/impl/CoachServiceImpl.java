package practice.service.impl;

import org.springframework.stereotype.Service;
import practice.repository.CoachDao;
import practice.model.Coach;
import practice.service.CoachService;
import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {
    private final CoachDao coachDao;

    public CoachServiceImpl(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    @Override
    public Coach add(Coach coach) {
        return coachDao.save(coach);
    }

    @Override
    public Coach get(Long id) {
        return coachDao.findById(id).orElseThrow(() -> new
                RuntimeException("Can't get coach by id: " + id));
    }

    @Override
    public List<Coach> getAll() {
        return coachDao.findAll();
    }

    @Override
    public void delete(Long id) {
        coachDao.deleteById(id);
    }
}
