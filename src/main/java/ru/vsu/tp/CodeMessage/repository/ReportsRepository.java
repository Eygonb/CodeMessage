package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Report;

import java.util.UUID;

public interface ReportsRepository extends CrudRepository<Report, UUID> {
}
