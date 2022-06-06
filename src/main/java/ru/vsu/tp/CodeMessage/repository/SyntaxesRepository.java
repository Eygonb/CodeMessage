package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.Syntax;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;

public interface SyntaxesRepository extends JpaRepository<Syntax, SyntaxesId> {
}
