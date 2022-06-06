package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.UserChat;
import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;

public interface UserChatsRepository extends JpaRepository<UserChat, UserChatsId> {
}
