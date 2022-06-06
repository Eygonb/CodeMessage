package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Report;
import ru.vsu.tp.CodeMessage.service.ReportsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reports")
@Api(description = "Контроллер жалоб")
public class ReportsController implements Controller<Report, UUID> {


    private ReportsService service;

//    @Override
//    @GetMapping
//    public List<Report> getAll() {
//        return service.getAll();
//    }

    @Override
    @GetMapping("/{id}")
    public Report get(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Report add(@RequestBody Report uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Report update(@RequestBody Report uploadedFiles, @PathVariable("id") UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Report uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
