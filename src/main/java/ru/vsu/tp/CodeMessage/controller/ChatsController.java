package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.config.jwt.TokenUtil;
import ru.vsu.tp.CodeMessage.entity.Chat;
import ru.vsu.tp.CodeMessage.service.ChatsService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/chats")
@Api(description = "Контроллер чатов")
public class ChatsController implements Controller<Chat, UUID> {
    private final ChatsService service;
    private final TokenUtil jwtTokenUtil;

    public ChatsController(ChatsService service, TokenUtil jwtTokenUtil) {
        this.service = service;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping
    public List<Chat> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                             @RequestParam(defaultValue = "") String search,
                             @RequestHeader(name="Authorization") String header) {
        String token = jwtTokenUtil.getTokenFromHeader(header);
        UUID userId = jwtTokenUtil.getUserIdFromToken(token);
        if (Objects.equals(search, ""))
            return service.getSome(userId, page, size);
        else return service.getSomeByName(userId, page, size, search);
    }

    @GetMapping("/open/{id}")
    public List<Chat> getOpenChats(@PathVariable("id") UUID id, @RequestParam int page, @RequestParam int size) {
        return service.getOpenChats(id, page, size);
    }

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
