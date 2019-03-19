package com.helpstudents.domain;

import com.helpstudents.entity.CustomerEntity;
import com.helpstudents.entity.WorkerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String description;
    private LocalDateTime dateCreate;
    private Date dateMade;
    private String status;
    private BigDecimal price;
    private CustomerEntity customerEntity;
    private WorkerEntity workerEntity;
    private String file;
}
