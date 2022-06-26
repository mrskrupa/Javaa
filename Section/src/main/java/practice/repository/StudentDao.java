package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
}
