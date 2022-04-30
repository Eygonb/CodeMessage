package ru.vsu.tp.CodeMessage.entity.id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

public class BlackListId implements Serializable {

    static final long serialVersionUid = 1L;

    @Column(name = "owner_id")
    private UUID ownerId;
    @Column(name = "user_id")
    private UUID userId;

    public BlackListId(UUID ownerId, UUID userId) {
        this.ownerId = ownerId;
        this.userId = userId;
    }

    public BlackListId() {  }

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
