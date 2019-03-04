package com.helpstudents.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderEntity extends BaseEntity {

    private String email;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime dateCreate;

    @Column(columnDefinition = "DATE")
    private Date dateMade;

    private String status;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity workerEntity;


}
