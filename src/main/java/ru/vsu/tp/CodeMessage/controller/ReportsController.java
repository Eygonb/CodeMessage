package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Reports;
import ru.vsu.tp.CodeMessage.entity.Reports;
import ru.vsu.tp.CodeMessage.service.ReportsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reports")
@Api(description = "Контроллер жалоб")
public class ReportsController implements Controller<Reports, UUID> {

    @Autowired
    private ReportsService service;

    @Override
    @GetMapping
    public List<Reports> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Reports get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Reports add(Reports uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Reports update(@RequestBody Reports uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Reports uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
