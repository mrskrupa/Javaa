package practice.service.impl;

import org.springframework.stereotype.Service;
import practice.repository.RankDao;
import practice.model.Rank;
import practice.service.RankService;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {
    private final RankDao rankDao;

    public RankServiceImpl(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    @Override
    public Rank add(Rank rank) {
        return rankDao.save(rank);
    }

    @Override
    public Rank get(Long id) {
        return rankDao.findById(id).orElseThrow(() ->
                new RuntimeException("Invalid input id: " + id));
    }

    @Override
    public List<Rank> getAll() {
        return rankDao.findAll();
    }

    @Override
    public void delete(Long id) {
        rankDao.deleteById(id);
    }
}
