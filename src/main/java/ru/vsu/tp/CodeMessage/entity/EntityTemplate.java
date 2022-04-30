package ru.vsu.tp.CodeMessage.entity;

public interface EntityTemplate<Entity, Id> {

    Entity updateTo(Entity entity);
    void setId(Id id);
}
