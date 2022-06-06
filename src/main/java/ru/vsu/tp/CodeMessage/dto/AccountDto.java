package ru.vsu.tp.CodeMessage.dto;

import ru.vsu.tp.CodeMessage.entity.Account;

import java.util.UUID;

public class AccountDto {
    private UUID id;
    private String username;
    private String email;
    private String type;
    private String title;
    private UUID imgId;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.email = account.getEmail();
        this.type = account.getType();
        this.title = account.getTitle();
        this.imgId = account.getImgId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getImgId() {
        return imgId;
    }

    public void setImgId(UUID imgId) {
        this.imgId = imgId;
    }
}
