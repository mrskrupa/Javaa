package practice.service;

import practice.model.Coach;
import java.util.List;

public interface CoachService {
    Coach add(Coach coach);

    Coach get(Long id);

    List<Coach> getAll();

    void delete(Long id);
}
