package com.helpstudents.repository;

import com.helpstudents.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {

    WorkerEntity findByNickName(String nickName);

    WorkerEntity findByEmail(String email);

    boolean existsByEmail(String email);
}
