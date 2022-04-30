package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vsu.tp.CodeMessage.entity.Reports;

import java.util.UUID;

public interface ReportsRepository extends CrudRepository<Reports, UUID>, Repository {
}
