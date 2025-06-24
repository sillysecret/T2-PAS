package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.enterprisebusinessrules.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteJpaRepository extends JpaRepository<ClienteEntity, Integer> {
}
