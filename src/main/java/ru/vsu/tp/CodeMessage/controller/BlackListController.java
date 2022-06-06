package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;
import ru.vsu.tp.CodeMessage.service.BlackListService;

import java.util.List;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;

@RestController
@RequestMapping("/black-list")
@Api(description = "Контроллер черных списков")
public class BlackListController implements Controller<BlackList, BlackListId> {

    @Autowired
    private BlackListService service;

//    @Override
//    @GetMapping
//    public List<BlackList> getAll() {
//        return service.getAll();
//    }

    @Override
    @GetMapping("/{id}")
    public BlackList get(@PathVariable("id") BlackListId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public BlackList add(@RequestBody BlackList uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public BlackList update(@RequestBody BlackList uploadedFiles, @PathVariable("id") BlackListId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") BlackListId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody BlackList uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
