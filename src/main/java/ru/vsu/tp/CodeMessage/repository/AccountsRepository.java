package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Accounts;

import java.util.UUID;

public interface AccountsRepository extends CrudRepository<Accounts, UUID>, Repository {
}
