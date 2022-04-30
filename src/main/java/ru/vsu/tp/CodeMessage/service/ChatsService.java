package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Chats;
import ru.vsu.tp.CodeMessage.entity.Chats;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChatsService implements ServiceTemplate<Chats, UUID> {

    private static ChatsService INSTANCE;
    @Autowired
    private ChatsRepository repository;

    public static ChatsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ChatsService();
        return INSTANCE;
    }

    private ChatsService() {  }

    @Override
    public List<Chats> getAll() {
        List<Chats> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Chats getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Chats add(Chats entity) {
        return repository.save(entity);
    }

    @Override
    public Chats update(Chats newEntity, UUID id) {
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
    public void delete(Chats entity) {
        repository.delete(entity);
    }

}
