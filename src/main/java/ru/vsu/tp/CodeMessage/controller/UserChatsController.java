package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.UserChats;
import ru.vsu.tp.CodeMessage.entity.UserChats;
import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;
import ru.vsu.tp.CodeMessage.service.UserChatsService;

import java.util.List;

@RestController
@RequestMapping("/user_chats")
@Api(description = "Контроллер связи чат-пользователь")
public class UserChatsController implements Controller<UserChats, UserChatsId> {

    @Autowired
    private UserChatsService service;

    @Override
    @GetMapping
    public List<UserChats> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public UserChats get(@PathVariable UserChatsId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public UserChats add(UserChats uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public UserChats update(@RequestBody UserChats uploadedFiles, @PathVariable UserChatsId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UserChatsId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UserChats uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
