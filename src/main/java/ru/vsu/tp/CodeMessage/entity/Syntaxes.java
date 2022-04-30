package ru.vsu.tp.CodeMessage.entity;

import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.UUID;

@Entity
@IdClass(SyntaxesId.class)
public class Syntaxes implements EntityTemplate<Syntaxes, SyntaxesId> {

    @Id
    @Column(name = "lang_id")
    private UUID langId;
    @Id
    private String keyword;
    private String color;

    public Syntaxes(UUID langId, String keyword, String color) {
        this.langId = langId;
        this.color = color;
        this.keyword = keyword;
    }

    public Syntaxes() {  }

    @Override
    public Syntaxes updateTo(Syntaxes syntaxes) {
        color = syntaxes.getColor();
        return this;
    }

    @Override
    public void setId(SyntaxesId syntaxesId) {
        langId = syntaxesId.getLangId();
        keyword = syntaxesId.getKeyword();
    }

    public UUID getLangId() {
        return langId;
    }

    public void setLangId(UUID langId) {
        this.langId = langId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
