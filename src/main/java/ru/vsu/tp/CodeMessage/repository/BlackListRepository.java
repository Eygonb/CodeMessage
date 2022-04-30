package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.BlackList;
import ru.vsu.tp.CodeMessage.entity.id.BlackListId;

public interface BlackListRepository extends CrudRepository<BlackList, BlackListId>, Repository {
}
