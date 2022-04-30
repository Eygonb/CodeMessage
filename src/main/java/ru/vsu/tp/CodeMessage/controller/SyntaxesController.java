package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Syntaxes;
import ru.vsu.tp.CodeMessage.entity.Syntaxes;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;
import ru.vsu.tp.CodeMessage.service.SyntaxesService;

import java.util.List;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;

@RestController
@RequestMapping("/syntaxes")
@Api(description = "Контроллер синтаксиса ЯП")
public class SyntaxesController implements Controller<Syntaxes, SyntaxesId> {

    @Autowired
    private SyntaxesService service;

    @Override
    @GetMapping
    public List<Syntaxes> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Syntaxes get(@PathVariable SyntaxesId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Syntaxes add(Syntaxes uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public Syntaxes update(@RequestBody Syntaxes uploadedFiles, @PathVariable SyntaxesId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable SyntaxesId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Syntaxes uploadedFiles) {
        service.delete(uploadedFiles);
    }

}
