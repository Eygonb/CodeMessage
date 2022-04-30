package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Langs;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;
import ru.vsu.tp.CodeMessage.repository.LangsRepository;

import java.util.UUID;

@Service
public class LangsService extends ServiceTemplate<Langs, UUID> {

    private static LangsService INSTANCE;

    public static LangsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LangsService();
        return INSTANCE;
    }

    private LangsService() {
        super(LangsRepository.class);
    }
}
