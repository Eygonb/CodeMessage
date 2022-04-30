package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Syntaxes;
import ru.vsu.tp.CodeMessage.entity.id.SyntaxesId;

public interface SyntaxesRepository extends CrudRepository<Syntaxes, SyntaxesId> {
}
