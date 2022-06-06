package ru.vsu.tp.CodeMessage.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.dto.AccountDto;
import ru.vsu.tp.CodeMessage.entity.Account;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.AccountsRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountsService {
    private final AccountsRepository repository;
    private final PasswordEncoder encoder;

    public AccountsService(AccountsRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<AccountDto> getAll() {
        List<AccountDto> target = new ArrayList<>();
        repository.findAll().stream().map(AccountDto::new).forEach(target::add);
        return target;
    }

    public List<AccountDto> getSomeByName(int page, int size, String search) {
        if (search != null)
            return repository.findByUsernameStartsWith(PageRequest.of(page, size), search).stream().map(AccountDto::new).collect(Collectors.toList());
        else
            return repository.findByUsernameStartsWith(PageRequest.of(page, size), "").stream().map(AccountDto::new).collect(Collectors.toList());
    }

    public AccountDto getById(UUID id) {
        Optional<Account> account = repository.findById(id);
        if (account.isPresent())
            return new AccountDto(account.get());
        else
            throw ObjectNotFoundException.getInstance();
    }

    public AccountDto getByUsername(String username) {
        return repository.findByUsername(username).map(AccountDto::new).orElse(null);
    }

    @Transactional
    public AccountDto add(Account entity) throws IllegalArgumentException {
        entity.setPassword(encoder.encode(entity.getPassword()));
        final boolean existsByUsername = repository.existsByUsername(entity.getUsername());
        final boolean existsByEmail = repository.existsByEmail(entity.getEmail());

        if (existsByEmail || existsByUsername) {
            String emailError = existsByEmail ? "Аккаунт с этим email уже существует " : "";
            String usernameError = existsByUsername ? "Аккаунт с этим username уже существует" : "";
            throw new IllegalArgumentException(emailError + usernameError);
        }

        return new AccountDto(repository.save(entity));
    }

    @Transactional
    public AccountDto update(Account newEntity, UUID id) {
        newEntity.setPassword(encoder.encode(newEntity.getPassword()));
        return repository.findById(id)
                .map(entity -> {
                    try {
                        entity.updateTo(newEntity);
                        return new AccountDto(repository.save(entity));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .orElseGet(() -> {
                    try {
                        newEntity.setId(id);
                        return new AccountDto(repository.save(newEntity));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                });
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    public void delete(Account entity) {
        repository.delete(entity);
    }

}
