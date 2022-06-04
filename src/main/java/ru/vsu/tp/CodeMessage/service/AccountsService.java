package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Accounts;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.AccountsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccountsService implements ServiceTemplate<Accounts, UUID> {

    private static AccountsService INSTANCE;
    @Autowired
    private AccountsRepository repository;

    public static AccountsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AccountsService();
        return INSTANCE;
    }

    private AccountsService() {  }

    @Override
    public List<Accounts> getAll() {
        List<Accounts> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Accounts getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Accounts add(Accounts entity) {
        return repository.save(entity);
    }

    @Override
    public Accounts update(Accounts newEntity, UUID id) {
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
    public void delete(Accounts entity) {
        repository.delete(entity);
    }

}
