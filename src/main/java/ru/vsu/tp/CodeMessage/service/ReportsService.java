package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Reports;
import ru.vsu.tp.CodeMessage.entity.Reports;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.MessagesRepository;
import ru.vsu.tp.CodeMessage.repository.ReportsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportsService implements ServiceTemplate<Reports, UUID> {

    private static ReportsService INSTANCE;
    @Autowired
    private ReportsRepository repository;

    public static ReportsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ReportsService();
        return INSTANCE;
    }

    private ReportsService() { }

    @Override
    public List<Reports> getAll() {
        List<Reports> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Reports getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Reports add(Reports entity) {
        return repository.save(entity);
    }

    @Override
    public Reports update(Reports newEntity, UUID id) {
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
    public void delete(Reports entity) {
        repository.delete(entity);
    }

}
