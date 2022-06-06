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

    @GetMapping()
    public List<Account> getByName(@RequestBody int page, @RequestBody int size, @RequestBody String search) {
        return service.getSomeByName(page, size, search);
    }

    @Override
    @GetMapping("/{id}")
    public Account get(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Account add(@RequestBody Account account) {
        return service.add(account);
    }

    @Override
    @PutMapping("/{id}")
    public Account update(@RequestBody Account account, @PathVariable("id") UUID id) {
        return service.update(account, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Account account) {
        service.delete(account);
    }
}
