package com.example.calllog.controller;

import com.example.calllog.model.CallLog;
import com.example.calllog.service.CallLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/logs")
public class CallLogController {

    @Autowired
    private CallLogService service;

        @PostMapping("/save")
        public ResponseEntity<?> saveLogs(@RequestBody List<CallLog> logs) {
            System.out.println("🔔 Received CallLog: ");
            logs.forEach(service::saveCallLog);
            return ResponseEntity.ok("Batch saved successfully");
        }




    @GetMapping("/all")
    public List<CallLog> getAllLogs() {
        return service.getAllLogs();
    }



    @GetMapping("/today")
    public List<CallLog> getTodayLogs() {
        return service.getTodaysLogs();
    }
}
