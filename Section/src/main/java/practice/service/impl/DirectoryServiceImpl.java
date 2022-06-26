package practice.service.impl;

import org.springframework.stereotype.Service;
import practice.repository.DirectoryDao;
import practice.model.Directory;
import practice.service.DirectoryService;
import java.util.List;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    private final DirectoryDao directoryDao;

    public DirectoryServiceImpl(DirectoryDao directoryDao) {
        this.directoryDao = directoryDao;
    }

    @Override
    public Directory add(Directory directory) {
        return directoryDao.save(directory);
    }

    @Override
    public Directory get(Long id) {
        return directoryDao.findById(id).orElseThrow(() ->
                new RuntimeException("Invalid input id: " + id));
    }

    @Override
    public List<Directory> getAll() {
        return directoryDao.findAll();
    }

    @Override
    public void delete(Long id) {
        directoryDao.deleteById(id);
    }
}
