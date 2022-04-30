package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UserChats;
import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.BlackListRepository;
import ru.vsu.tp.CodeMessage.repository.UserChatsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserChatsService implements ServiceTemplate<UserChats, UserChatsId> {

    private static UserChatsService INSTANCE;
    @Autowired
    private UserChatsRepository repository;

    public static UserChatsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UserChatsService();
        return INSTANCE;
    }

    private UserChatsService() {  }

    @Override
    public List<UserChats> getAll() {
        List<UserChats> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public UserChats getById(UserChatsId id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public UserChats add(UserChats entity) {
        return repository.save(entity);
    }

    @Override
    public UserChats update(UserChats newEntity, UserChatsId id) {
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
    public void delete(UserChatsId id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(UserChats entity) {
        repository.delete(entity);
    }

}
