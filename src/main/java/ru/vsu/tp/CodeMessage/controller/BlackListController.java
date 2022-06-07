package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.config.jwt.TokenUtil;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;
import ru.vsu.tp.CodeMessage.service.BlackListService;

import java.util.List;
import java.util.UUID;

import ru.vsu.tp.CodeMessage.entity.id.BlackListId;

@RestController
@RequestMapping("/black-list")
@Api(description = "Контроллер черных списков")
public class BlackListController {
    private final BlackListService service;
    private final TokenUtil jwtTokenUtil;

    public BlackListController(BlackListService service, TokenUtil jwtTokenUtil) {
        this.service = service;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/{id}")
    public boolean get(@PathVariable("id") UUID userid, @RequestHeader(name="Authorization") String header) {
        String token = jwtTokenUtil.getTokenFromHeader(header);
        UUID ownerId = jwtTokenUtil.getUserIdFromToken(token);
        return service.isBlocked(ownerId, userid);
    }

    @PostMapping
    public BlackList add(@RequestBody BlackList uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @PutMapping("/{id}")
    public BlackList update(@RequestBody BlackList uploadedFiles, @PathVariable("id") BlackListId id) {
        return service.update(uploadedFiles, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") BlackListId id) {
        service.delete(id);
    }

    @DeleteMapping
    public void delete(@RequestBody BlackList uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
