package ru.vsu.tp.CodeMessage.service;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.EntityTemplate;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class ServiceTemplate<Entity extends EntityTemplate, Id> {
    private CrudRepository<Entity, Id> repository;

//    TODO(Только бы работало...)
    public ServiceTemplate(Class<? extends CrudRepository<Entity, Id>> repositoryClass) {
        repository = (repositoryClass.cast(repository));
    }

    public List<Entity> getAll() {
        List<Entity> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target;
    }

    public Entity getById(Id id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    public Entity add(Entity entity) {
        return repository.save(entity);
    }

    public Entity update(Entity newEntity, Id id) {
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

    public void delete(Id id) {
        repository.deleteById(id);
    }

    public void delete(Entity entity) {
        repository.delete(entity);
    }

    public CrudRepository<Entity, Id> getRepository() {
        return repository;
    }
}
