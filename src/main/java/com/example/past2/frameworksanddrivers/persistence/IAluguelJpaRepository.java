package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.interfaceadapters.entity.AluguelEntity;
import com.example.past2.interfaceadapters.entity.JogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAluguelJpaRepository extends JpaRepository<AluguelEntity, Integer> {

}
