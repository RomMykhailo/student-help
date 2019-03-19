package com.helpstudents.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "admins")
public class AdminEntity extends PeopleBaseEntity {

    private String firstName;

    private String lastName;

    private boolean isDeleted;
}
