package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.model.Unit;

@Repository
public interface UnitDao extends JpaRepository<Unit, Long> {
}
