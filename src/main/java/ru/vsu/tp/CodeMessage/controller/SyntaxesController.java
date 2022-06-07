package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.Lang;
import ru.vsu.tp.CodeMessage.entity.Syntax;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;
import ru.vsu.tp.CodeMessage.service.LangsService;
import ru.vsu.tp.CodeMessage.service.SyntaxesService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/syntaxes")
@Api(description = "Контроллер синтаксиса ЯП")
public class SyntaxesController {
    private final SyntaxesService service;

    public SyntaxesController(SyntaxesService service) {
        this.service = service;
    }

    @ApiOperation("Получение карты ключевого слова и его цвета")
    @GetMapping("/{lang}")
    public Map<String, String> get(@PathVariable("lang") String lang) {
        return service.getSyntax(lang);
    }

    @ApiOperation("Добавление ключевого слова")
    @PostMapping
    public Syntax add(@RequestBody Syntax uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @ApiOperation("Обновления поля ключевого слова")
    @PutMapping("/{id}")
    public Syntax update(@RequestBody Syntax uploadedFiles, @PathVariable("id") SyntaxesId id) {
        return service.update(uploadedFiles, id);
    }

    @ApiOperation("Удаление ключевого слова по составному ключу")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") SyntaxesId id) {
        service.delete(id);
    }

    @ApiOperation("Удаление по объекту")
    @DeleteMapping
    public void delete(@RequestBody Syntax uploadedFiles) {
        service.delete(uploadedFiles);
    }

}
