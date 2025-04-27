package com.example.calllog.repository;

import com.example.calllog.model.CallLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CallLogRepository extends JpaRepository<CallLog, Long> {
    List<CallLog> findByCallTimeBetween(LocalDateTime start, LocalDateTime end);
    List<CallLog> findAllByOrderByCallTimeDesc();

}
