package com.example.past2.infrastructure.persistence;

import com.example.past2.infrastructure.persistence.entity.JogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoJpaRepository extends JpaRepository<JogoEntity, Long> {
}

