package ru.vsu.tp.CodeMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Langs implements EntityTemplate<Langs, UUID> {

    @Id
    private UUID id;
    @Column(name = "lang_name")
    private String langName;
    @Column(name = "file_type")
    private String fileType;

    public Langs(UUID id, String langName, String fileType) {
        this.id = id;
        this.langName = langName;
        this.fileType = fileType;
    }

    public Langs() {  }

    @Override
    public Langs updateTo(Langs langs) {
        langName = langs.getLangName();
        fileType = langs.getFileType();
        return this;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
