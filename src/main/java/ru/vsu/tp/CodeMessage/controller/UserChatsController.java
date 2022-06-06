package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.UserChat;
import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;
import ru.vsu.tp.CodeMessage.service.UserChatsService;

import java.util.List;

@RestController
@RequestMapping("/user_chats")
@Api(description = "Контроллер связи чат-пользователь")
public class UserChatsController implements Controller<UserChat, UserChatsId> {
    private final UserChatsService service;

    public UserChatsController(UserChatsService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/{id}")
    public UserChat get(@PathVariable("id") UserChatsId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public UserChat add(@RequestBody UserChat uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public UserChat update(@RequestBody UserChat uploadedFiles, @PathVariable("id") UserChatsId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UserChatsId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UserChat uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
