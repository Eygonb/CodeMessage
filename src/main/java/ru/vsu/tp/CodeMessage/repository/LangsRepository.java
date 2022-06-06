package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.Lang;

import java.util.UUID;

public interface LangsRepository extends JpaRepository<Lang, UUID> {
}
