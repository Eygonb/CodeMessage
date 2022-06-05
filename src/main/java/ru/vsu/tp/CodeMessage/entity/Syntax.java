package ru.vsu.tp.CodeMessage.entity;

import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;

import javax.persistence.*;
import java.util.UUID;

@Entity
@IdClass(SyntaxesId.class)
@Table(name = "syntaxes")
public class Syntax implements EntityTemplate<Syntax, SyntaxesId> {

    @Id
    @Column(name = "lang_id")
    private UUID langId;
    @Id
    private String keyword;
    private String color;

    public Syntax(UUID langId, String keyword, String color) {
        this.langId = langId;
        this.color = color;
        this.keyword = keyword;
    }

    public Syntax() {  }

    @Override
    public Syntax updateTo(Syntax syntax) {
        color = syntax.getColor();
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
