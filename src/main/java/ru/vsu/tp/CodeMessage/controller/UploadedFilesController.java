package ru.vsu.tp.CodeMessage.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.entity.UploadedFiles;
import ru.vsu.tp.CodeMessage.service.UploadedFilesService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/uploaded_files")
@Tag(name = "Загруженные файлы", description = "")
public class UploadedFilesController implements Controller<UploadedFiles, UUID> {

    private static final UploadedFilesService service = UploadedFilesService.getInstance();

    @Override
    @GetMapping
    public List<UploadedFiles> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public UploadedFiles get(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public UploadedFiles add(UploadedFiles uploadedFiles) {
        return service.add(uploadedFiles);
    }

    @Override
    @PutMapping("/{id}")
    public UploadedFiles update(@RequestBody UploadedFiles uploadedFiles, @PathVariable UUID id) {
        return service.update(uploadedFiles, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UploadedFiles uploadedFiles) {
        service.delete(uploadedFiles);
    }
}
