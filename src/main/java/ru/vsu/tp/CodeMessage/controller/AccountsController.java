package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Accounts;
import ru.vsu.tp.CodeMessage.service.AccountsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@Api(description = "Контроллер аккаунтов пользователей")
public class AccountsController implements Controller<Accounts, UUID> {

    @Autowired
    private AccountsService service;

    @Override
    @GetMapping
    public List<Accounts> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Accounts get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Accounts add(Accounts uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Accounts update(@RequestBody Accounts uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Accounts uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
