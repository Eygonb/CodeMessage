package ru.vsu.tp.CodeMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "messages")
public class Message implements EntityTemplate<Message, UUID> {

    @Id
    private UUID id;
    @Column(name = "text_msg")
    private String textMsg;
//    TODO(Что-то сделать с типом)
    private String type;
    @Column(name = "chat_id")
    private UUID chatId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "time_msg")
    private ZonedDateTime timeMsg;
    @Column(name = "was_changed")
    private boolean wasChanged;
    @Column(name = "was_read")
    private boolean wasRead;
    private UUID reply;
    @Column(name = "attachment_id")
    private UUID attachmentId;

    public Message(UUID id, String textMsg, String type, UUID chatId, UUID userId, ZonedDateTime timeMsg,
                   boolean wasChanged, boolean wasRead, UUID reply, UUID attachmentId) {
        this.attachmentId = attachmentId;
        this.id = id;
        this.chatId = chatId;
        this.textMsg = textMsg;
        this.userId = userId;
        this.type = type;
        this.timeMsg = timeMsg;
        this.wasChanged = wasChanged;
        this.wasRead = wasRead;
        this.reply = reply;
    }

    public Message() {  }

    @Override
    public Message updateTo(Message message) {
        attachmentId = message.getAttachmentId();
        chatId = message.getChatId();
        textMsg = message.getTextMsg();
        userId = message.getUserId();
        type = message.getType();
        timeMsg = message.getTimeMsg();
        wasRead = message.isWasRead();
        wasChanged = message.isWasChanged();
        reply = message.getReply();
        return this;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTextMsg() {
        return textMsg;
    }

    public void setTextMsg(String textMsg) {
        this.textMsg = textMsg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public ZonedDateTime getTimeMsg() {
        return timeMsg;
    }

    public void setTimeMsg(ZonedDateTime timeMsg) {
        this.timeMsg = timeMsg;
    }

    public boolean isWasChanged() {
        return wasChanged;
    }

    public void setWasChanged(boolean wasChanged) {
        this.wasChanged = wasChanged;
    }

    public boolean isWasRead() {
        return wasRead;
    }

    public void setWasRead(boolean wasRead) {
        this.wasRead = wasRead;
    }

    public UUID getReply() {
        return reply;
    }

    public void setReply(UUID reply) {
        this.reply = reply;
    }

    public UUID getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(UUID attachmentId) {
        this.attachmentId = attachmentId;
    }
}
