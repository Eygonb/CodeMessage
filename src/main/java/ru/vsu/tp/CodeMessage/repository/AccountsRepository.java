package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountsRepository extends CrudRepository<Account, UUID> {
    Optional<Account> findByUsername(String username);

    //TODO(Уточнить, как реализуется поиск записей)
    List<Account> findByUsernameStartsWith(Pageable pageable, String username);
}
