package com.example.past2.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.past2.adapter.entity.JogoEntity;

public interface IJogoJpaRepository extends JpaRepository<JogoEntity, Integer> {
    
}

