package com.helpstudents.repository;

import com.helpstudents.entity.StatusWorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusWorkerRepository extends JpaRepository<StatusWorkerEntity,Long> {
}
