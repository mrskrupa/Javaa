package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.model.Directory;

@Repository
public interface DirectoryDao extends JpaRepository<Directory, Long> {
}
