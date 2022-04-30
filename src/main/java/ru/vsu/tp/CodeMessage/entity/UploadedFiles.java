package ru.vsu.tp.CodeMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "uploaded_files")
public class UploadedFiles implements EntityTemplate<UploadedFiles, UUID> {
    @Id
    private UUID id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;


    public UploadedFiles(UUID id, String fileName, String filePath) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public UploadedFiles() {  }

    @Override
    public UploadedFiles updateTo(UploadedFiles entity) {
        filePath = entity.getFilePath();
        fileName = entity.getFileName();
        return this;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
