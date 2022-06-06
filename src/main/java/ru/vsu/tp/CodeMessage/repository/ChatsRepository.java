package ru.vsu.tp.CodeMessage.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vsu.tp.CodeMessage.entity.Chat;
import org.springframework.data.domain.Pageable;
import ru.vsu.tp.CodeMessage.entity.type.ChatType;

import java.util.List;
import java.util.UUID;

public interface ChatsRepository extends JpaRepository<Chat, UUID> {

    //TODO(Написать запрос)
    //  Выборка чатов пользователя с пагинацией и сортировкой по времени сообщения
    @Query(value = "(select id, type, img_id, chat_name, time_msg from " +
            "(select * from chats where id in (select chat_id from user_chats where user_id = :userId)) " +
            "left join (select chat_id, max(time_msg) as time_msg from messages group by chat_id) on id = chat_id " +
            "order by time_msg desc) limit (:from, :to)", nativeQuery = true)
    List<Chat> findChatOrderByLastMessage(@Param("userId") UUID userId, @Param("from") int from, @Param("to") int to);

    //TODO(И тут тоже)
    //  Выборка чатов пользователя по названию с пагинацией и сортировкой по времени сообщения
    @Query(value = "(select id, type, img_id, chat_name, time_msg from " +
            "(select * from chats where id in (select chat_id from user_chats where user_id = :userId)) " +
            "left join (select chat_id, max(time_msg) as time_msg from messages group by chat_id) on id = chat_id " +
            "where lower(chat_name) like '%' || lower(:search) || '%' order by time_msg desc) limit (:from, :to)",
            nativeQuery = true)
    List<Chat> findChatByChatNameOrderByLastMessage(@Param("userId") UUID userId, @Param("from") int from,
                                                    @Param("to") int to, @Param("search") String search);

    List<Chat> findByIdAndType(Pageable pageable, UUID id, ChatType type);
}
