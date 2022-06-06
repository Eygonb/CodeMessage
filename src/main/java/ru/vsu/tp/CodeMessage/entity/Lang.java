package ru.vsu.tp.CodeMessage.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "langs")
public class Lang implements EntityTemplate<Lang, UUID> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(name = "lang_name")
    private String langName;
    @Column(name = "file_type")
    private String fileType;

    public Lang(UUID id, String langName, String fileType) {
        this.id = id;
        this.langName = langName;
        this.fileType = fileType;
    }

    public Lang() {  }

    @Override
    public Lang updateTo(Lang lang) {
        langName = lang.getLangName();
        fileType = lang.getFileType();
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
