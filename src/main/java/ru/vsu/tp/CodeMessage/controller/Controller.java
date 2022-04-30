package ru.vsu.tp.CodeMessage.controller;

import ru.vsu.tp.CodeMessage.entity.EntityTemplate;

import java.util.List;

public interface Controller<Entity extends EntityTemplate, Id> {

    List<Entity> getAll();
    Entity get(Id id);
    Entity add(Entity entity);
    Entity update(Entity entity, Id id);
    void delete(Id id);
    void delete(Entity entity);
}
