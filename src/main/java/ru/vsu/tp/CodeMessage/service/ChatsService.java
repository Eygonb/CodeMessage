package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Chats;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;

import java.util.UUID;

@Service
public class ChatsService extends ServiceTemplate<Chats, UUID> {

    private static ChatsService INSTANCE;

    public static ChatsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ChatsService();
        return INSTANCE;
    }

    private ChatsService() {
        super(ChatsRepository.class);
    }
}
