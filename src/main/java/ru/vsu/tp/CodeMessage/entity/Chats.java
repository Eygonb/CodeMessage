package ru.vsu.tp.CodeMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Chats implements EntityTemplate<Chats, UUID> {

    @Id
    private UUID id;
    private String type;
    @Column(name = "img_id")
    private UUID imgId;
    @Column(name = "chat_name")
    private String chatName;

    public Chats(UUID id, String type, UUID imgId, String chatName) {
        this.chatName = chatName;
        this.id = id;
        this.imgId = imgId;
        this.type = type;
    }

    public Chats() {  }

    @Override
    public Chats updateTo(Chats chats) {
        type = chats.getType();
        imgId = chats.getImgId();
        chatName = chats.getChatName();
        return this;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String text) {
        this.type = text;
    }

    public UUID getImgId() {
        return imgId;
    }

    public void setImgId(UUID imgId) {
        this.imgId = imgId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
}
