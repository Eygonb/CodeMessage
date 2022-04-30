package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Langs;
import ru.vsu.tp.CodeMessage.entity.Langs;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;
import ru.vsu.tp.CodeMessage.repository.LangsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LangsService implements ServiceTemplate<Langs, UUID> {

    private static LangsService INSTANCE;
    @Autowired
    private LangsRepository repository;

    public static LangsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LangsService();
        return INSTANCE;
    }

    private LangsService() { }

    @Override
    public List<Langs> getAll() {
        List<Langs> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Langs getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Langs add(Langs entity) {
        return repository.save(entity);
    }

    @Override
    public Langs update(Langs newEntity, UUID id) {
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
    public void delete(Langs entity) {
        repository.delete(entity);
    }

}
