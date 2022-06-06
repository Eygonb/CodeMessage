package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.dto.AccountDto;
import ru.vsu.tp.CodeMessage.entity.Account;
import ru.vsu.tp.CodeMessage.service.AccountsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@Api(description = "Контроллер аккаунтов пользователей")
public class AccountsController {
    private final AccountsService service;

    public AccountsController(AccountsService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation("Получение списка всех объектов")
    public List<AccountDto> getAll(@RequestParam int page, @RequestParam int size, @RequestParam String search) {
        return service.getSomeByName(page, size, search);
    }

    @GetMapping("/{id}")
    @ApiOperation("Получение объекта по идентификатору")
    public AccountDto get(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PostMapping("/register")
    @ApiOperation("Добавление нового объекта")
    public ResponseEntity add(@RequestBody Account account) {
        try {
            AccountDto accountDto = service.add(account);
            return ResponseEntity.ok(accountDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновление данных существующего объекта")
    public AccountDto update(@RequestBody Account account, @PathVariable("id") UUID id) {
        return service.update(account, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаление объекта по его идентификатору")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }

    @DeleteMapping
    @ApiOperation("Удаление выбранного объекта")
    public void delete(@RequestBody Account account) {
        service.delete(account);
    }
}
