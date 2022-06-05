package ru.vsu.tp.CodeMessage.entity;

import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "unread_msgs")
@IdClass(UnreadMsgsId.class)
public class UnreadMsg implements EntityTemplate<UnreadMsg, UnreadMsgsId> {

    @Id
    @Column(name = "user_id")
    private UUID userId;
    @Id
    @Column(name = "msg_id")
    private UUID msgId;

    public UnreadMsg(UUID userId, UUID msgId) {
        this.userId = userId;
        this.msgId = msgId;
    }

    public UnreadMsg() {  }

    @Override
    public UnreadMsg updateTo(UnreadMsg unreadMsg) {
        userId = unreadMsg.getUserId();
        msgId = unreadMsg.getMsgId();
        return this;
    }

    @Override
    public void setId(UnreadMsgsId unreadMsgsId) {
        userId = unreadMsgsId.getUserId();
        msgId = unreadMsgsId.getMsgId();
    }

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
