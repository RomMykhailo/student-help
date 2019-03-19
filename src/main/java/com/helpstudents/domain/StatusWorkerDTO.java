package com.helpstudents.domain;

import com.helpstudents.entity.AdminEntity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StatusWorkerDTO {
    private Long id;
    private String status;
    private String description;
    private LocalDateTime dateTime;
    private AdminEntity adminEntity;
}
