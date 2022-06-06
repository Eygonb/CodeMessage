package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Message;
import ru.vsu.tp.CodeMessage.service.MessagesService;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
@Api(description = "Контроллер сообщений")
public class MessagesController implements Controller<Message, UUID> {

    @Autowired
    private MessagesService service;

    @Override
    @GetMapping
    public List<Message> getAll() {
        return service.getAll();
    }

    @GetMapping("/chats/{id}")
    public List<Message> getMessagesInChat(@PathVariable("id") UUID id, @RequestBody int page, @RequestBody int size) {
        return service.getMessagesInChat(id, page, size);
    }

    @Override
    @GetMapping("/{id}")
    public Message get(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Message add(@RequestBody Message uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Message update(@RequestBody Message uploadedFiles, @PathVariable("id") UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Message uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
