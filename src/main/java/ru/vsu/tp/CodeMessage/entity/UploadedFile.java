package ru.vsu.tp.CodeMessage.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "uploaded_files")
public class UploadedFile implements EntityTemplate<UploadedFile, UUID> {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;


    public UploadedFile(UUID id, String fileName, String filePath) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public UploadedFile() {  }

    @Override
    public UploadedFile updateTo(UploadedFile entity) {
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
