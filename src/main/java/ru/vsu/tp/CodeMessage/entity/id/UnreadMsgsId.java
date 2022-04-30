package ru.vsu.tp.CodeMessage.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
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
}
