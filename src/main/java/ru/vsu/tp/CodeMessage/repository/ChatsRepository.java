package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Chats;

import java.util.UUID;

public interface ChatsRepository extends CrudRepository<Chats, UUID>, Repository {
}
