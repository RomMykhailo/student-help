package com.helpstudents.domain;

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

    @NotNull(message = "Field 'Email' can not be null")
    @Size(min=5, max=100, message = "Not valid length 'email'")
    private String email;

    private String description;

    private LocalDateTime dateCreate;

    private Date dateMade;

    private String status;

    private BigDecimal price;

    private WorkerEntity workerEntity;
}
