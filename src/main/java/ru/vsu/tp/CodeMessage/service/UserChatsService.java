package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UserChat;
import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.UserChatsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserChatsService implements ServiceTemplate<UserChat, UserChatsId> {
    private UserChatsRepository repository;

    public UserChatsService(UserChatsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserChat> getAll() {
        List<UserChat> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public UserChat getById(UserChatsId id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public UserChat add(UserChat entity) {
        return repository.save(entity);
    }

    @Override
    public UserChat update(UserChat newEntity, UserChatsId id) {
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
    public void delete(UserChat entity) {
        repository.delete(entity);
    }

}
