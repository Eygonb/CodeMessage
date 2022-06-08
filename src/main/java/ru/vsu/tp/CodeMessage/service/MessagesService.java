package ru.vsu.tp.CodeMessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Account;
import ru.vsu.tp.CodeMessage.entity.Chat;
import ru.vsu.tp.CodeMessage.entity.Message;
import ru.vsu.tp.CodeMessage.entity.UnreadMsg;
import ru.vsu.tp.CodeMessage.entity.id.UnreadMsgsId;
import ru.vsu.tp.CodeMessage.entity.type.ChatType;
import ru.vsu.tp.CodeMessage.exception.exceptions.ObjectNotFoundException;
import ru.vsu.tp.CodeMessage.repository.MessagesRepository;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MessagesService implements ServiceTemplate<Message, UUID> {
    private MessagesRepository repository;
    private ChatsService chatsService;
    private UnreadMsgsService unreadMsgsService;

    public MessagesService(MessagesRepository repository, ChatsService chatsService, UnreadMsgsService unreadMsgsService) {
        this.repository = repository;
        this.chatsService = chatsService;
        this.unreadMsgsService = unreadMsgsService;
    }

    public List<Message> getMessagesInChat(UUID chatId, int page, int size, UUID userId) {
        Chat chat = chatsService.getById(chatId);
        if (chat.getType() == ChatType.OPEN_GROUP)
            return repository.findByChatIdOrderByTimeMsgDesc(PageRequest.of(page, size), chatId);
        boolean isIn = false;
        for (Account user : chat.getAccounts())
            if (user.getId() == userId) {
                isIn = true;
                break;
            }
        if (isIn) {
            List<Message> messages = repository.findByChatIdOrderByTimeMsgDesc(PageRequest.of(page, size), chatId);
            List<UnreadMsgsId> unreadMsgsIds = messages.stream().map(message ->
                    new UnreadMsgsId(userId, message.getId())).collect(Collectors.toList());
            for (UnreadMsgsId var : unreadMsgsIds)
                unreadMsgsService.delete(var);
            Collections.reverse(messages);
            return messages;
        } else return null;
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
    public Message add(Message msg) {
        msg.setTimeMsg(ZonedDateTime.now());
        msg = repository.save(msg);
        Set<Account> users = chatsService.getById(msg.getChatId()).getAccounts();
        for (Account user : users)
            if (user.getId() != msg.getUserId())
                unreadMsgsService.add(new UnreadMsg(user.getId(), msg.getId()));
        return msg;
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
