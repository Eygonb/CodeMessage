package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessagesRepository extends JpaRepository<Message, UUID> {

    //TODO(Проверить)
    List<Message> findByChatIdOrderByTimeMsgDesc(Pageable pageable, UUID chatId);
}
