package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.model.Rank;

@Repository
public interface RankDao extends JpaRepository<Rank, Long> {
}
