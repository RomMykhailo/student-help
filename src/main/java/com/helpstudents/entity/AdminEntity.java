package com.helpstudents.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admins")
public class AdminEntity extends BaseEntity {
    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private String phoneNumber;
    private String firstName;

    private String lastName;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}
