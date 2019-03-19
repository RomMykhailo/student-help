package com.helpstudents.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity extends PeopleBaseEntity {

    private String nickName;

    @Column(name = "description")
    private String description;

    private LocalDateTime dateCreate;

    private boolean isDeleted;
}
