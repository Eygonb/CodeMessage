package ru.vsu.tp.CodeMessage.entity;

import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_chats")
@IdClass(UserChatsId.class)
public class UserChats implements EntityTemplate<UserChats, UserChatsId> {

    @Id
    @Column(name = "user_id")
    private UUID userId;
    @Id
    @Column(name = "chat_id")
    private UUID chatId;
//    TODO(Определить и обработать тип)
    private String type;

    public UserChats(UUID userId, UUID chatId, String type) {
        this.userId = userId;
        this.type = type;
        this.chatId = chatId;
    }

    public UserChats() {  }

    @Override
    public UserChats updateTo(UserChats userChats) {
        type = userChats.getType();
        chatId = userChats.getChatId();
        userId = userChats.getUserId();
        return null;
    }

    @Override
    public void setId(UserChatsId userChatsId) {
        userId = userChatsId.getUserId();
        chatId = userChatsId.getChatId();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
