package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.BlackListRepository;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;

import java.util.ArrayList;
import java.util.List;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;

@Service
public class BlackListService implements ServiceTemplate<BlackList, BlackListId> {
    private BlackListRepository repository;

    public BlackListService(BlackListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BlackList> getAll() {
        List<BlackList> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public BlackList getById(BlackListId id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public BlackList add(BlackList entity) {
        return repository.save(entity);
    }

    @Override
    public BlackList update(BlackList newEntity, BlackListId id) {
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
    public void delete(BlackListId id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(BlackList entity) {
        repository.delete(entity);
    }

}
