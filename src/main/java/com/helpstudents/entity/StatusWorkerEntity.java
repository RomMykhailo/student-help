package com.helpstudents.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "status_worker")
public class StatusWorkerEntity extends BaseEntity {

    private String status;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity adminEntity;


}
