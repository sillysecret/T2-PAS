package com.example.past2.frameworksanddrivers.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.past2.enterprisebusinessrules.entity.JogoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IJogoJpaRepository extends JpaRepository<JogoEntity, Integer> {
}
