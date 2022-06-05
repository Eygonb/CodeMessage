package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Account;
import ru.vsu.tp.CodeMessage.service.AccountsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@Api(description = "Контроллер аккаунтов пользователей")
public class AccountsController implements Controller<Account, UUID> {

    @Autowired
    private AccountsService service;

    @Override
    @GetMapping
    public List<Account> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Account get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Account add(Account uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Account update(@RequestBody Account uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Account uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
