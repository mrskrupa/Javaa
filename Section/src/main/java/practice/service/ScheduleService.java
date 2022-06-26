package practice.service;

import practice.model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule add(Schedule schedule);

    Schedule get(Long id);

    List<Schedule> getAll();

    void delete(Long id);
}
