package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Report;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.ReportsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportsService implements ServiceTemplate<Report, UUID> {
    private ReportsRepository repository;

    public ReportsService(ReportsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Report> getAll() {
        List<Report> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Report getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Report add(Report entity) {
        return repository.save(entity);
    }

    @Override
    public Report update(Report newEntity, UUID id) {
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
    public void delete(Report entity) {
        repository.delete(entity);
    }

}
