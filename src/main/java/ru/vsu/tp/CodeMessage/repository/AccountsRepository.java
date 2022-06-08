package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountsRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findByUsername(String username);

    List<Account> findByUsernameStartsWith(Pageable pageable, String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
