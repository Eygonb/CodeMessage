package ru.vsu.tp.CodeMessage.service;

import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Reports;
import ru.vsu.tp.CodeMessage.repository.MessagesRepository;
import ru.vsu.tp.CodeMessage.repository.ReportsRepository;

import java.util.UUID;

@Service
public class ReportsService extends ServiceTemplate<Reports, UUID> {

    private static ReportsService INSTANCE;

    public static ReportsService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ReportsService();
        return INSTANCE;
    }

    private ReportsService() {
        super(ReportsRepository.class);
    }
}
