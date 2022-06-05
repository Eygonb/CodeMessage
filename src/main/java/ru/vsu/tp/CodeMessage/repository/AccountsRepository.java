package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Account;

import java.util.UUID;

public interface AccountsRepository extends CrudRepository<Account, UUID> {
    public Account findByUsername(String username);
}
