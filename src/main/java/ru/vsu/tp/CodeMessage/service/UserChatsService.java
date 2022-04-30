package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.UserChats;
import ru.vsu.tp.CodeMessage.entity.id.UserChatsId;
import ru.vsu.tp.CodeMessage.repository.BlackListRepository;
import ru.vsu.tp.CodeMessage.repository.UserChatsRepository;

@Service
public class UserChatsService extends ServiceTemplate<UserChats, UserChatsId> {

    private static UserChatsService INSTANCE;

    public static UserChatsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UserChatsService();
        return INSTANCE;
    }

    private UserChatsService() {
        super(UserChatsRepository.class);
    }
}
