package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.model.School;

@Repository
public interface SchoolDao extends JpaRepository<School, Long> {
}
