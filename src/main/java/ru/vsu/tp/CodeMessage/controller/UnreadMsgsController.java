package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.UnreadMsg;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;
import ru.vsu.tp.CodeMessage.service.UnreadMsgsService;

import java.util.List;

@RestController
@RequestMapping("/unread_msgs")
@Api(description = "Контроллер непрочитанных сообщений")
public class UnreadMsgsController implements Controller<UnreadMsg, UnreadMsgsId> {

    private UnreadMsgsService service;

    @Override
    @GetMapping("/{id}")
    public UnreadMsg get(@PathVariable("id") UnreadMsgsId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public UnreadMsg add(@RequestBody UnreadMsg uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public UnreadMsg update(@RequestBody UnreadMsg uploadedFiles, @PathVariable("id") UnreadMsgsId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UnreadMsgsId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UnreadMsg uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
