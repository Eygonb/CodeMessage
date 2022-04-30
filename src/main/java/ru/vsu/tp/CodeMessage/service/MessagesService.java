package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Messages;
import ru.vsu.tp.CodeMessage.repository.MessagesRepository;

import java.util.UUID;

@Service
public class MessagesService extends ServiceTemplate<Messages, UUID> {

    private static MessagesService INSTANCE;

    public static MessagesService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MessagesService();
        return INSTANCE;
    }

    private MessagesService() {
        super(MessagesRepository.class);
    }
}
