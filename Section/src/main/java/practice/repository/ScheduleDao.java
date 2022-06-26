package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.model.Schedule;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Long> {
}
