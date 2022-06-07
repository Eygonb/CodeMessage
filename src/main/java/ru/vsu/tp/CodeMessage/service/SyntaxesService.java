package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Syntax;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.SyntaxesRepository;

import java.util.*;

@Service
public class SyntaxesService implements ServiceTemplate<Syntax, SyntaxesId> {
    private final SyntaxesRepository repository;
    private final LangsService langsService;

    public SyntaxesService(SyntaxesRepository repository, LangsService langsService) {
        this.repository = repository;
        this.langsService = langsService;
    }

    public Map<String, String> getSyntax(String lang) {
        UUID langId = langsService.getLangIdByName(lang);
        List<Syntax> syn = repository.findAllByLangId(langId);
        HashMap<String, String> map = new HashMap<>();
        for (Syntax a : syn)
            map.put(a.getKeyword(), a.getColor());
        return map;
    }

    @Override
    public List<Syntax> getAll() {
        List<Syntax> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Syntax getById(SyntaxesId id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Syntax add(Syntax entity) {
        return repository.save(entity);
    }

    @Override
    public Syntax update(Syntax newEntity, SyntaxesId id) {
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
    public void delete(Syntax entity) {
        repository.delete(entity);
    }

}
