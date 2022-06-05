package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.UserChat;
import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;

public interface UserChatsRepository extends CrudRepository<UserChat, UserChatsId> {
}
