package com.example.demo.repository;

import com.example.demo.entity.OdontologoEntity;
import com.example.demo.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<OdontologoEntity, Long> {
}
