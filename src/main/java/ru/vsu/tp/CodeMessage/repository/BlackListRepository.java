package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;

public interface BlackListRepository extends JpaRepository<BlackList, BlackListId> {
}
