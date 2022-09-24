package com.example.demo.repository;

import com.example.demo.dto.TurnoDTO;
import com.example.demo.entity.OdontologoEntity;
import com.example.demo.entity.TurnoEntity;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {

    @Query("SELECT t FROM TurnoEntity as t WHERE odontologo_id = ?1 and fecha_creacion = ?2")
    List<TurnoEntity> obtenerTurnoDisponibleConOdontologoYFecha(Long id, LocalDate fecha);

}
