package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Message;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.MessagesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MessagesService implements ServiceTemplate<Message, UUID> {
    private MessagesRepository repository;

    public MessagesService(MessagesRepository repository) {
        this.repository = repository;
    }

    public List<Message> getMessagesInChat(UUID chatId, int page, int size) {
        return repository.findByChatIdOrderByTimeMsgDesc(PageRequest.of(page, size), chatId);
    }

    @Override
    public List<Message> getAll() {
        List<Message> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        System.out.println(target);
        return target;
    }

    @Override
    public Message getById(UUID id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            throw ObjectNotFoundException.getInstance();
    }

    @Override
    public Message add(Message entity) {
        return repository.save(entity);
    }

    @Override
    public Message update(Message newEntity, UUID id) {
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
    public void delete(Message entity) {
        repository.delete(entity);
    }

}
