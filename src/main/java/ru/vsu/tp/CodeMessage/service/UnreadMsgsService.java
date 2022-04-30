package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UnreadMsgs;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;
import ru.vsu.tp.CodeMessage.repository.UnreadMsgsRepository;
import ru.vsu.tp.CodeMessage.repository.UserChatsRepository;

@Service
public class UnreadMsgsService extends ServiceTemplate<UnreadMsgs, UnreadMsgsId> {

    private static UnreadMsgsService INSTANCE;

    public static UnreadMsgsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UnreadMsgsService();
        return INSTANCE;
    }

    private UnreadMsgsService() {
        super(UnreadMsgsRepository.class);
    }
}
