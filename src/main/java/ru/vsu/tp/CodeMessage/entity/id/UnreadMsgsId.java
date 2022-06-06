package ru.vsu.tp.CodeMessage.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UnreadMsgsId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "msg_id")
    private UUID msgId;

    public UnreadMsgsId(UUID userId, UUID msgId) {
        this.userId = userId;
        this.msgId = msgId;
    }

    public UnreadMsgsId() {  }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getMsgId() {
        return msgId;
    }

    public void setMsgId(UUID msgId) {
        this.msgId = msgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnreadMsgsId that = (UnreadMsgsId) o;
        return userId.equals(that.userId) && msgId.equals(that.msgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, msgId);
    }
}
