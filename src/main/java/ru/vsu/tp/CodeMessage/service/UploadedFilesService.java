package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UploadedFiles;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.UploadedFilesRepository;
import ru.vsu.tp.CodeMessage.repository.UserChatsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UploadedFilesService implements ServiceTemplate<UploadedFiles, UUID> {

    private static UploadedFilesService INSTANCE;
    @Autowired
    private UploadedFilesRepository repository;

    public static UploadedFilesService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UploadedFilesService();
        return INSTANCE;
    }

    private UploadedFilesService() {  }

    @Override
    public List<UploadedFiles> getAll() {
        List<UploadedFiles> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public UploadedFiles getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public UploadedFiles add(UploadedFiles entity) {
        return repository.save(entity);
    }

    @Override
    public UploadedFiles update(UploadedFiles newEntity, UUID id) {
        return repository.findById(id)
                .map(entity -> {
                    try {
                        entity.updateTo(newEntity);
                        return repository.save(entity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .orElseGet(() -> {
                    try {
                        newEntity.setId(id);
                        return repository.save(newEntity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(UploadedFiles entity) {
        repository.delete(entity);
    }

}
