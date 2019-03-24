package com.helpstudents.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "workers")
public class WorkerEntity extends PeopleBaseEntity {

    @Column (name = "nick", nullable = false)
    private String nickName;

    @Column(name = "description")
    private String description;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal money;

    private LocalDateTime dateCreate;

    @OneToOne
    @JoinColumn(name = "status_id")
    private StatusWorkerEntity status;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "worker_role", joinColumns = @JoinColumn(name="worker_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;

}
