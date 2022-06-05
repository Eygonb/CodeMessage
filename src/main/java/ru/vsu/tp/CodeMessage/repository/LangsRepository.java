package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Lang;

import java.util.UUID;

public interface LangsRepository extends CrudRepository<Lang, UUID> {
}
