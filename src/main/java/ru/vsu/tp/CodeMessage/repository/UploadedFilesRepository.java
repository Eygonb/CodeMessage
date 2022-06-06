package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.UploadedFile;

import java.util.UUID;

public interface UploadedFilesRepository extends JpaRepository<UploadedFile, UUID> {
}
