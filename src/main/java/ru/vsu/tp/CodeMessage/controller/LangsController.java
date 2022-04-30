package ru.vsu.tp.CodeMessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Langs;
import ru.vsu.tp.CodeMessage.entity.Langs;
import ru.vsu.tp.CodeMessage.service.LangsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/langs")
public class LangsController implements Controller<Langs, UUID> {

    @Autowired
    private LangsService service;

    @Override
    @GetMapping
    public List<Langs> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Langs get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Langs add(Langs uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Langs update(@RequestBody Langs uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Langs uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
