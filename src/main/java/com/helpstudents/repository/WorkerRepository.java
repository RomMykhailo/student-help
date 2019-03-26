package com.helpstudents.repository;

import com.helpstudents.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
    boolean existsByEmail(String email);

    Optional<WorkerEntity> findByEmail(String Email);

    Optional<WorkerEntity> findByNickName (String nickName);
}
