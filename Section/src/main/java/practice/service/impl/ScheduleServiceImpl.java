package practice.service.impl;

import org.springframework.stereotype.Service;
import practice.repository.ScheduleDao;
import practice.model.Schedule;
import practice.service.ScheduleService;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleDao scheduleDao;

    public ScheduleServiceImpl(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @Override
    public Schedule add(Schedule schedule) {
        return scheduleDao.save(schedule);
    }

    @Override
    public Schedule get(Long id) {
        return scheduleDao.findById(id).orElseThrow(() ->
                new RuntimeException("Invalid input id: " + id));
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleDao.findAll();
    }

    @Override
    public void delete(Long id) {
        scheduleDao.deleteById(id);
    }
}
