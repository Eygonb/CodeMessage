package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.UnreadMsg;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;

public interface UnreadMsgsRepository extends CrudRepository<UnreadMsg, UnreadMsgsId> {
}
