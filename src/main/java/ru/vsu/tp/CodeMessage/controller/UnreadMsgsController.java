package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.UnreadMsgs;
import ru.vsu.tp.CodeMessage.entity.UnreadMsgs;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;
import ru.vsu.tp.CodeMessage.service.UnreadMsgsService;

import java.util.List;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;

@RestController
@RequestMapping("/unread_msgs")
@Api(description = "Контроллер непрочитанных сообщений")
public class UnreadMsgsController implements Controller<UnreadMsgs, UnreadMsgsId> {

    @Autowired
    private UnreadMsgsService service;

    @Override
    @GetMapping
    public List<UnreadMsgs> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public UnreadMsgs get(@PathVariable UnreadMsgsId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public UnreadMsgs add(UnreadMsgs uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public UnreadMsgs update(@RequestBody UnreadMsgs uploadedFiles, @PathVariable UnreadMsgsId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UnreadMsgsId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UnreadMsgs uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
