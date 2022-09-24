package com.example.demo.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turno")
@Data
public class TurnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaCreacion;

    //generamos la relacion con odontologo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "odontologo_id", insertable = false, updatable = false)
    private OdontologoEntity odontologo;

    @Column(name = "odontologo_id", nullable = false)
    private Long odontologoId;

    //generamos la relacion con paciente
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private PacienteEntity paciente;

    @Column(name = "paciente_id", nullable = false)
    private Long pacienteId;


}
