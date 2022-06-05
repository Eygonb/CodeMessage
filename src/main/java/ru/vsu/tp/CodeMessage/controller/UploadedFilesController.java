package ru.vsu.tp.CodeMessage.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.UploadedFile;
import ru.vsu.tp.CodeMessage.service.UploadedFilesService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/uploaded_files")
@Api(description = "Контроллер загруженных файлов")
public class UploadedFilesController implements Controller<UploadedFile, UUID> {

    @Autowired
    private UploadedFilesService service;

    @Override
    @GetMapping
    public List<UploadedFile> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public UploadedFile get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public UploadedFile add(UploadedFile uploadedFile) {
        return service.add(uploadedFile);
    }

    @Override
    @PutMapping("/{id}")
    public UploadedFile update(@RequestBody UploadedFile uploadedFile, @PathVariable UUID id) {
        return service.update(uploadedFile, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UploadedFile uploadedFile) {
        service.delete(uploadedFile);
    }
}
