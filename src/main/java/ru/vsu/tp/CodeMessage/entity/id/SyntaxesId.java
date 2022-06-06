package ru.vsu.tp.CodeMessage.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class SyntaxesId implements Serializable {

    @Column(name = "lang_id")
    private UUID langId;
    private String keyword;

    public SyntaxesId(UUID langId, String keyword) {
        this.langId = langId;
        this.keyword = keyword;
    }

    public SyntaxesId() {  }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyntaxesId that = (SyntaxesId) o;
        return langId.equals(that.langId) && keyword.equals(that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langId, keyword);
    }
}
