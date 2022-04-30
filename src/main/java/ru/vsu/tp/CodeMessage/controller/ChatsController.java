package ru.vsu.tp.CodeMessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Chats;
import ru.vsu.tp.CodeMessage.entity.Chats;
import ru.vsu.tp.CodeMessage.service.ChatsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chats")
public class ChatsController implements Controller<Chats, UUID> {

    @Autowired
    private ChatsService service;

    @Override
    @GetMapping
    public List<Chats> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Chats get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Chats add(Chats uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Chats update(@RequestBody Chats uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Chats uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
