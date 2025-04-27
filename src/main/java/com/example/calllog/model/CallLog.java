package com.example.calllog.model;

import javax.persistence.*;  // ✅ for Java 8
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String callType;
    private LocalDateTime callTime;
    private int duration;
}
