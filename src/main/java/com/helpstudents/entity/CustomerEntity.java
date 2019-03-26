package com.helpstudents.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private String phoneNumber;

    private String nickName;

    @Column(name = "description")
    private String description;

    private LocalDateTime dateCreate;

    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}
