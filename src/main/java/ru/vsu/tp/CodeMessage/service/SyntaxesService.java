package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Syntaxes;
import ru.vsu.tp.CodeMessage.entity.Syntaxes;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;
import ru.vsu.tp.CodeMessage.repository.SyntaxesRepository;

import java.util.ArrayList;
import java.util.List;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;

@Service
public class SyntaxesService implements ServiceTemplate<Syntaxes, SyntaxesId> {

    private static SyntaxesService INSTANCE;
    @Autowired
    private SyntaxesRepository repository;

    public static SyntaxesService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SyntaxesService();
        return INSTANCE;
    }

    private SyntaxesService() {  }

    @Override
    public List<Syntaxes> getAll() {
        List<Syntaxes> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Syntaxes getById(SyntaxesId id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Syntaxes add(Syntaxes entity) {
        return repository.save(entity);
    }

    @Override
    public Syntaxes update(Syntaxes newEntity, SyntaxesId id) {
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
    public void delete(SyntaxesId id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Syntaxes entity) {
        repository.delete(entity);
    }

}
