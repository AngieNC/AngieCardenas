package com.example.AngieCardenas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AngieCardenas.persistence.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation, Object> {
    
}
