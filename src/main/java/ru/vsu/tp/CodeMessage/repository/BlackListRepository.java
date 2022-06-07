package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;

import java.util.List;
import java.util.UUID;

public interface BlackListRepository extends JpaRepository<BlackList, BlackListId> {

    BlackList findByOwnerIdAndUserId(UUID ownerId, UUID userId);
}
