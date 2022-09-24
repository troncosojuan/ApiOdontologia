package com.example.demo.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "paciente")
public class PacienteEntity {

    //ID, Apellido, Nombre, Email, DNI, Fecha ingreso)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apellido;
    private String nombre;
    private String email;
    private Integer dni;

    @Column(name = "fecha_ingreso")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaIngreso;

    @OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "domicilio_id")
    private DomicilioEntity domicilio;

}
