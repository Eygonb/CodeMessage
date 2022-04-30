package ru.vsu.tp.CodeMessage.controller;

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
public class BlackListController implements Controller<BlackList, BlackListId> {

    @Autowired
    private BlackListService service;

    @Override
    @GetMapping
    public List<BlackList> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public BlackList get(@PathVariable BlackListId id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public BlackList add(BlackList uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public BlackList update(@RequestBody BlackList uploadedFiles, @PathVariable BlackListId id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BlackListId id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody BlackList uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
