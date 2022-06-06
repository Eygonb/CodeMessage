package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.UnreadMsg;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;

public interface UnreadMsgsRepository extends JpaRepository<UnreadMsg, UnreadMsgsId> {
}
