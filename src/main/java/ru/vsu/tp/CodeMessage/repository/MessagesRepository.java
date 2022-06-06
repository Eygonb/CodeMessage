package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessagesRepository extends CrudRepository<Message, UUID> {

    //TODO(Проверить)
    List<Message> findByChatIdOrderByTimeMsgDesc(Pageable pageable, UUID chatId);
}
