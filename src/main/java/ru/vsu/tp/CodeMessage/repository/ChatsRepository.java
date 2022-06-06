package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Chat;
import org.springframework.data.domain.Pageable;
import ru.vsu.tp.CodeMessage.entity.type.ChatType;

import java.util.List;
import java.util.UUID;

public interface ChatsRepository extends CrudRepository<Chat, UUID> {

    //TODO(Написать запрос)
    //  Выборка чатов пользователя с пагинацией и сортировкой по времени сообщения
    @Query("select id, type, img_id, chat_name from chats join messages on chats.id = messages.chat_id where ;")
    List<Chat> findChatOrderByLastMessage(UUID userId, Pageable pageable);

    //TODO(И тут тоже)
    //  Выборка чатов пользователя по названию с пагинацией и сортировкой по времени сообщения
    @Query("")
    List<Chat> findChatByChatNameOrderByLastMessage(UUID userId, Pageable pageable, String search);

    List<Chat> findByIdAndType(Pageable pageable, UUID id, ChatType type);
}
