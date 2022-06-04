package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Messages;
import ru.vsu.tp.CodeMessage.entity.Messages;
import ru.vsu.tp.CodeMessage.service.MessagesService;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
@Api(description = "Контроллер сообщений")
public class MessagesController implements Controller<Messages, UUID> {

    @Autowired
    private MessagesService service;

    @Override
    @GetMapping
    public List<Messages> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Messages get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Messages add(Messages uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Messages update(@RequestBody Messages uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Messages uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
