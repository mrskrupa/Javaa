package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.model.Coach;

@Repository
public interface CoachDao extends JpaRepository<Coach, Long> {
}
