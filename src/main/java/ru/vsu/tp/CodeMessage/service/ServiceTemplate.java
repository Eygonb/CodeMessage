package ru.vsu.tp.CodeMessage.service;

import ru.vsu.tp.CodeMessage.entity.EntityTemplate;

import java.util.List;

public interface ServiceTemplate<Entity extends EntityTemplate, Id> {

    List<Entity> getAll();
    Entity getById(Id id);
    Entity add(Entity entity);
    Entity update(Entity newEntity, Id id);
    void delete(Id id);
    void delete(Entity entity);
}
