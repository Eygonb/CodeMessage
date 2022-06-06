package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UnreadMsg;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.UnreadMsgsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnreadMsgsService implements ServiceTemplate<UnreadMsg, UnreadMsgsId> {
    private UnreadMsgsRepository repository;

    public UnreadMsgsService(UnreadMsgsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UnreadMsg> getAll() {
        List<UnreadMsg> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public UnreadMsg getById(UnreadMsgsId id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public UnreadMsg add(UnreadMsg entity) {
        return repository.save(entity);
    }

    @Override
    public UnreadMsg update(UnreadMsg newEntity, UnreadMsgsId id) {
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
    public void delete(UnreadMsg entity) {
        repository.delete(entity);
    }

}
