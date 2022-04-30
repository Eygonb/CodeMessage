package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Accounts;
import ru.vsu.tp.CodeMessage.repository.AccountsRepository;

import javax.persistence.Entity;
import java.util.UUID;

@Service
public class AccountsService extends ServiceTemplate<Accounts, UUID> {

    private static AccountsService INSTANCE;

    public static AccountsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AccountsService();
        return INSTANCE;
    }

    private AccountsService() {
        super(AccountsRepository.class);
    }
}
