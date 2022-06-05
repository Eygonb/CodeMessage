package ru.vsu.tp.CodeMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account implements EntityTemplate<Account, UUID> {

    @Id
    private UUID id;
    private String username;
    private String email;
    private String password;
//    TODO(Что-то сделать с типом)
    private String type;
    private String title;
    @Column(name = "img_id")
    private UUID imgId;

    public Account(UUID id, String username, String email,
                   String password, String type, String title, UUID imgId) {
        this.id = id;
        this.email = email;
        this.imgId = imgId;
        this.password = password;
        this.title = title;
        this.type = type;
        this.username = username;
    }

    public Account() {  }

    @Override
    public Account updateTo(Account account) {
        email = account.getEmail();
        imgId = account.getImgId();
        password = account.getPassword();
        title = account.getTitle();
        type = account.getType();
        username = account.getUsername();
        return this;
    }

    public UUID getId() {
        return id;
    }

    @Override
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
