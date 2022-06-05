package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Lang;
import ru.vsu.tp.CodeMessage.service.LangsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/langs")
@Api(description = "Контроллер языков программирования (ЯП)")
public class LangsController implements Controller<Lang, UUID> {

    @Autowired
    private LangsService service;

    @Override
    @GetMapping
    public List<Lang> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Lang get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Lang add(Lang uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Lang update(@RequestBody Lang uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Lang uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
