package ru.vsu.tp.CodeMessage.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UserChatsId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "chat_id")
    private UUID chatId;

    public UserChatsId(UUID userId, UUID chatId) {
        this.userId = userId;
        this.chatId = chatId;
    }

    public UserChatsId() {  }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChatsId that = (UserChatsId) o;
        return userId.equals(that.userId) && chatId.equals(that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, chatId);
    }
}
