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

    private LangsService service;

    @Override
    @GetMapping("/{id}")
    public Lang get(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Lang add(@RequestBody Lang uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Lang update(@RequestBody Lang uploadedFiles, @PathVariable("id") UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Lang uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
