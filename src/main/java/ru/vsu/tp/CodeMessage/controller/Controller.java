package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.ApiOperation;
import ru.vsu.tp.CodeMessage.entity.EntityTemplate;

import java.util.List;

public interface Controller<Entity extends EntityTemplate, Id> {

//    @ApiOperation("Получение списка всех объектов")
//    List<Entity> getAll();
    @ApiOperation("Получение объекта по идентификатору")
    Entity get(Id id);
    @ApiOperation("Добавление нового объекта")
    Entity add(Entity entity);
    @ApiOperation("Обновление данных существующего объекта")
    Entity update(Entity entity, Id id);
    @ApiOperation("Удаление объекта по его идентификатору")
    void delete(Id id);
    @ApiOperation("Удаление выбранного объекта")
    void delete(Entity entity);
}
