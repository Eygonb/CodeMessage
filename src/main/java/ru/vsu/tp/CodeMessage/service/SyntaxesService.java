package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Syntaxes;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;
import ru.vsu.tp.CodeMessage.repository.SyntaxesRepository;

@Service
public class SyntaxesService extends ServiceTemplate<Syntaxes, SyntaxesId> {

    private static SyntaxesService INSTANCE;

    public static SyntaxesService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SyntaxesService();
        return INSTANCE;
    }

    private SyntaxesService() {
        super(SyntaxesRepository.class);
    }
}
