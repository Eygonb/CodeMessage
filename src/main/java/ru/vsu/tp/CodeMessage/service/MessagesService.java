package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Messages;
import ru.vsu.tp.CodeMessage.entity.Messages;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.MessagesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MessagesService implements ServiceTemplate<Messages, UUID> {

    private static MessagesService INSTANCE;
    @Autowired
    private MessagesRepository repository;

    public static MessagesService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MessagesService();
        return INSTANCE;
    }

    private MessagesService() {  }

    @Override
    public List<Messages> getAll() {
        List<Messages> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Messages getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Messages add(Messages entity) {
        return repository.save(entity);
    }

    @Override
    public Messages update(Messages newEntity, UUID id) {
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
    public void delete(Messages entity) {
        repository.delete(entity);
    }

}
