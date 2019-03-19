package com.helpstudents.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

   @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime dateCreate;

    @Column(columnDefinition = "DATE")
    private Date dateMade;

    private String file;

    private String status;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity workerEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

}
