package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Chat;

import java.util.UUID;

public interface ChatsRepository extends CrudRepository<Chat, UUID> {
}
