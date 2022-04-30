package ru.vsu.tp.CodeMessage.entity;

import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "unread_msgs")
@IdClass(UnreadMsgsId.class)
public class UnreadMsgs implements EntityTemplate<UnreadMsgs, UnreadMsgsId> {

    @Id
    @Column(name = "user_id")
    private UUID userId;
    @Id
    @Column(name = "msg_id")
    private UUID msgId;

    public UnreadMsgs(UUID userId, UUID msgId) {
        this.userId = userId;
        this.msgId = msgId;
    }

    public UnreadMsgs() {  }

    @Override
    public UnreadMsgs updateTo(UnreadMsgs unreadMsgs) {
        userId = unreadMsgs.getUserId();
        msgId = unreadMsgs.getMsgId();
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
