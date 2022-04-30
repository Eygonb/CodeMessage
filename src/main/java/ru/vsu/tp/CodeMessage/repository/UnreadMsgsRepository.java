package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.UnreadMsgs;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;

public interface UnreadMsgsRepository extends CrudRepository<UnreadMsgs, UnreadMsgsId>, Repository {
}
