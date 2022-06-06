package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Syntax;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;
import ru.vsu.tp.CodeMessage.service.SyntaxesService;

import java.util.List;

@RestController
@RequestMapping("/syntaxes")
@Api(description = "Контроллер синтаксиса ЯП")
public class SyntaxesController implements Controller<Syntax, SyntaxesId> {

    @Autowired
    private SyntaxesService service;

    @Override
    @GetMapping
    public List<Syntax> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Syntax get(@PathVariable("id") SyntaxesId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Syntax add(@RequestBody Syntax uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Syntax update(@RequestBody Syntax uploadedFiles, @PathVariable("id") SyntaxesId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") SyntaxesId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Syntax uploadedFiles) {
        service.delete(uploadedFiles);
    }

}
