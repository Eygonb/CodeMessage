package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Account;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.AccountsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccountsService implements ServiceTemplate<Account, UUID> {
    private AccountsRepository repository;

    public AccountsService(AccountsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Account> getAll() {
        List<Account> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Account getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    public Account getByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    @Override
    public Account add(Account entity) {
        return repository.save(entity);
    }

    @Override
    public Account update(Account newEntity, UUID id) {
        return repository.findById(id)
                .map(entity -> {
                    try {
                        entity.updateTo(newEntity);
                        return repository.save(entity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .orElseGet(() -> {
                    try {
                        newEntity.setId(id);
                        return repository.save(newEntity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                });
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Account entity) {
        repository.delete(entity);
    }

}
