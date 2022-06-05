package ru.vsu.tp.CodeMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "reports")
public class Report implements EntityTemplate<Report, UUID> {

    @Id
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    private String reason;

    public Report(UUID id, UUID userId, String reason) {
        this.id = id;
        this.userId = userId;
        this.reason = reason;
    }

    public Report() {  }

    @Override
    public Report updateTo(Report report) {
        userId = report.getUserId();
        reason = report.getReason();
        return this;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
