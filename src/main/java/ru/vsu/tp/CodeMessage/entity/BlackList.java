package ru.vsu.tp.CodeMessage.entity;

import ru.vsu.tp.CodeMessage.entity.id.BlackListId;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "black_list")
@IdClass(BlackListId.class)
public class BlackList implements EntityTemplate<BlackList, BlackListId> {

    @Id
    @Column(name = "owner_id")
    private UUID ownerId;
    @Id
    @Column(name = "user_id")
    private UUID userId;

    public BlackList(UUID ownerId, UUID userId) {
        this.ownerId = ownerId;
        this.userId = userId;
    }

    public BlackList() {  }

    @Override
    public BlackList updateTo(BlackList blackList) {
        ownerId = blackList.getOwnerId();
        userId = blackList.getUserId();
        return this;
    }

    @Override
    public void setId(BlackListId blackListId) {
        setOwnerId(blackListId.getOwnerId());
        setUserId(blackListId.getUserId());
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
