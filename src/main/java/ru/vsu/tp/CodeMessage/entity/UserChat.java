package ru.vsu.tp.CodeMessage.entity;

import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;
import ru.vsu.tp.CodeMessage.entity.type.UserChatType;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_chats")
@IdClass(UserChatsId.class)
public class UserChat implements EntityTemplate<UserChat, UserChatsId> {

    @Id
    @Column(name = "user_id")
    private UUID userId;
    @Id
    @Column(name = "chat_id")
    private UUID chatId;
    //    TODO(Определить и обработать тип)
    @Enumerated(EnumType.STRING)
    private UserChatType type;

    public UserChat(UUID userId, UUID chatId, UserChatType type) {
        this.userId = userId;
        this.type = type;
        this.chatId = chatId;
    }

    public UserChat() {
    }

    @Override
    public UserChat updateTo(UserChat userChat) {
        type = userChat.getType();
        chatId = userChat.getChatId();
        userId = userChat.getUserId();
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

    public UserChatType getType() {
        return type;
    }

    public void setType(UserChatType type) {
        this.type = type;
    }
}
