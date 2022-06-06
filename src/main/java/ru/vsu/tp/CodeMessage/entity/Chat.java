package ru.vsu.tp.CodeMessage.entity;

import org.hibernate.annotations.GenericGenerator;
import ru.vsu.tp.CodeMessage.entity.type.ChatType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chats")
public class Chat implements EntityTemplate<Chat, UUID> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ChatType type;
    @Column(name = "img_id")
    private UUID imgId;
    @Column(name = "chat_name")
    private String chatName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_chats",
            joinColumns = {@JoinColumn(name = "chat_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<Account> accounts = new HashSet<>();

    public Chat(UUID id, ChatType type, UUID imgId, String chatName) {
        this.chatName = chatName;
        this.id = id;
        this.imgId = imgId;
        this.type = type;
    }

    public Chat() {  }

    @Override
    public Chat updateTo(Chat chat) {
        type = chat.getType();
        imgId = chat.getImgId();
        chatName = chat.getChatName();
        return this;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public ChatType getType() {
        return type;
    }

    public void setType(ChatType type) {
        this.type = type;
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
