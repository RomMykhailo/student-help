package com.helpstudents.domain;

import com.helpstudents.entity.CustomerEntity;
import com.helpstudents.entity.WorkerEntity;
import lombok.Data;

@Data
public class RespondDTO {

    private String description;

    private WorkerEntity workerEntity;

    private CustomerEntity customerEntity;

    private boolean isDeleted;
}
