package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Message;

import java.util.UUID;

public interface MessagesRepository extends CrudRepository<Message, UUID> {

}
