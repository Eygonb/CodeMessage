package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.UploadedFiles;

import java.util.UUID;

public interface UploadedFilesRepository extends CrudRepository<UploadedFiles, UUID> {
}
