package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Chat;
import ru.vsu.tp.CodeMessage.service.ChatsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chats")
@Api(description = "Контроллер чатов")
public class ChatsController implements Controller<Chat, UUID> {

    private ChatsService service;


    @GetMapping
    public List<Chat> getAll(@RequestParam int page, @RequestParam int size, @RequestParam String search) {
        //TODO(Разобраться с получением id пользователя)
        UUID userId = UUID.randomUUID();
        if (search != null)
            return service.getSome(userId, page, size);
        else return service.getSomeByName(userId, page, size, search);
    }

    @GetMapping("/open/{id}")
    public List<Chat> getOpenChats(@PathVariable("id") UUID id, @RequestParam int page, @RequestParam int size) {
        return service.getOpenChats(id, page, size);
    }

//    @GetMapping
//    public List<Chat> getSomeByName(@RequestParam int page, @RequestParam int size, @RequestParam String search) {
//        //TODO(Разобраться с получением id пользователя)
//        UUID userId = UUID.randomUUID();
//
//    }

    @Override
    @GetMapping("/{id}")
    public Chat get(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Chat add(@RequestBody Chat uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Chat update(@RequestBody Chat uploadedFiles, @PathVariable("id") UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Chat uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
