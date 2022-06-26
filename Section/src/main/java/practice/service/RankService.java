package practice.service;

import practice.model.Rank;

import java.util.List;

public interface RankService {
    Rank add(Rank rank);

    Rank get(Long id);

    List<Rank> getAll();

    void delete(Long id);
}
