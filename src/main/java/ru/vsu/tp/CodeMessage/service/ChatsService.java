package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Chat;
import ru.vsu.tp.CodeMessage.entity.type.ChatType;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.ChatsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChatsService implements ServiceTemplate<Chat, UUID> {
    private ChatsRepository repository;

    public ChatsService(ChatsRepository repository) {
        this.repository = repository;
    }

    public List<Chat> getOpenChats(UUID chatId, int page, int size) {
        return repository.findByIdAndType(PageRequest.of(page, size), chatId, ChatType.OPEN_GROUP);
    }

    public List<Chat> getSomeByName(UUID userId, int page, int size, String search) {
        int from = (page + 1) * size - size;
        return repository.findChatByChatNameOrderByLastMessage(userId, from, size, search);
    }

    //      TODO(Доделать и отладить)
    public List<Chat> getSome(UUID userId, int page, int size) {
        int from = (page + 1) * size - size;
        return repository.findChatOrderByLastMessage(userId, from, size);
    }

    @Override
    public List<Chat> getAll() {
        List<Chat> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Chat getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Chat add(Chat entity) {
        return repository.save(entity);
    }

    @Override
    public Chat update(Chat newEntity, UUID id) {
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
    public void delete(Chat entity) {
        repository.delete(entity);
    }

}
