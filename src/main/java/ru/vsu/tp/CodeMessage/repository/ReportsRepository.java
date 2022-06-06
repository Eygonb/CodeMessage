package ru.vsu.tp.CodeMessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.tp.CodeMessage.entity.Report;

import java.util.UUID;

public interface ReportsRepository extends JpaRepository<Report, UUID> {
}
