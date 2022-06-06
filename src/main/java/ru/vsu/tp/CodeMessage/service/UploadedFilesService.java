package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UploadedFile;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.UploadedFilesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UploadedFilesService implements ServiceTemplate<UploadedFile, UUID> {
    private UploadedFilesRepository repository;

    public UploadedFilesService(UploadedFilesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UploadedFile> getAll() {
        List<UploadedFile> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public UploadedFile getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public UploadedFile add(UploadedFile entity) {
        return repository.save(entity);
    }

    @Override
    public UploadedFile update(UploadedFile newEntity, UUID id) {
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
    public void delete(UploadedFile entity) {
        repository.delete(entity);
    }

}
