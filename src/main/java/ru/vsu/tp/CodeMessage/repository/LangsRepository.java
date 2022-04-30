package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Langs;

import java.util.UUID;

public interface LangsRepository extends CrudRepository<Langs, UUID> {
}
