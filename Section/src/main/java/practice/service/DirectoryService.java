package practice.service;

import practice.model.Directory;

import java.util.List;

public interface DirectoryService {
    Directory add(Directory directory);

    Directory get(Long id);

    List<Directory> getAll();

    void delete(Long id);
}
