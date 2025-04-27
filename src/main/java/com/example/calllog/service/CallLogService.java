package com.example.calllog.service;

import com.example.calllog.model.CallLog;
import com.example.calllog.repository.CallLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CallLogService {

    private static final Logger logger = LoggerFactory.getLogger(CallLogService.class);

    @Autowired
    private CallLogRepository repository;

    public void saveCallLog(CallLog log) {
        logger.info("Saving call log: {}", log); // Log incoming data
        repository.save(log);
    }

    public List<CallLog> getTodaysLogs() {
        LocalDateTime start = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        List<CallLog> logs = repository.findByCallTimeBetween(start, end);
        logger.info("Fetched {} call logs for today.", logs.size());
        return logs;
    }

    public List<CallLog> getAllLogs() {
        List<CallLog> allLogs = repository.findAllByOrderByCallTimeDesc();
        logger.info("Fetched total {} call logs.", allLogs.size());
        return allLogs;
    }
}
