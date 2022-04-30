package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;
import ru.vsu.tp.CodeMessage.repository.BlackListRepository;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;

@Service
public class BlackListService extends ServiceTemplate<BlackList, BlackListId> {

    private static BlackListService INSTANCE;

    public static BlackListService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BlackListService();
        return INSTANCE;
    }

    private BlackListService() {
        super(BlackListRepository.class);
    }
}
