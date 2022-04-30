package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UnreadMsgs;
import ru.vsu.tp.CodeMessage.entity.UnreadMsgs;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.UnreadMsgsRepository;
import ru.vsu.tp.CodeMessage.repository.UserChatsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnreadMsgsService implements ServiceTemplate<UnreadMsgs, UnreadMsgsId> {

    private static UnreadMsgsService INSTANCE;
    @Autowired
    private UnreadMsgsRepository repository;

    public static UnreadMsgsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UnreadMsgsService();
        return INSTANCE;
    }

    private UnreadMsgsService() {  }

    @Override
    public List<UnreadMsgs> getAll() {
        List<UnreadMsgs> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public UnreadMsgs getById(UnreadMsgsId id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public UnreadMsgs add(UnreadMsgs entity) {
        return repository.save(entity);
    }

    @Override
    public UnreadMsgs update(UnreadMsgs newEntity, UnreadMsgsId id) {
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
    public void delete(UnreadMsgsId id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(UnreadMsgs entity) {
        repository.delete(entity);
    }

}
