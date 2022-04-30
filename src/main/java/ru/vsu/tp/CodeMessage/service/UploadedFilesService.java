package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UploadedFiles;
import ru.vsu.tp.CodeMessage.repository.UploadedFilesRepository;

import java.util.UUID;

@Service
public class UploadedFilesService extends ServiceTemplate<UploadedFiles, UUID> {

    private static UploadedFilesService INSTANCE;

    public static UploadedFilesService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UploadedFilesService();
        return INSTANCE;
    }

    private UploadedFilesService() {
        super(UploadedFilesRepository.class);
    }
}
