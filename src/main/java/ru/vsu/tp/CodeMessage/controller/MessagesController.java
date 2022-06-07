package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.config.jwt.TokenUtil;
import ru.vsu.tp.CodeMessage.entity.Message;
import ru.vsu.tp.CodeMessage.service.MessagesService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
@Api(description = "Контроллер сообщений")
public class MessagesController implements Controller<Message, UUID> {
    private final MessagesService service;
    private final TokenUtil jwtTokenUtil;

    public MessagesController(MessagesService service, TokenUtil jwtTokenUtil) {
        this.service = service;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/chats/{id}")
    public List<Message> getMessagesInChat(@PathVariable("id") UUID id, @RequestParam int page,
                                           @RequestParam int size, @RequestHeader(name = "Authorization") String header) {
        String token = jwtTokenUtil.getTokenFromHeader(header);
        UUID userId = jwtTokenUtil.getUserIdFromToken(token);
        return service.getMessagesInChat(id, page, size, userId);
    }

    @GetMapping("/chats/open/{id}")
    public List<Message> getMessagesInOpenChat(@PathVariable("id") UUID id, @RequestParam int page, @RequestParam int size) {
        return service.getMessagesInChat(id, page, size, null);
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
