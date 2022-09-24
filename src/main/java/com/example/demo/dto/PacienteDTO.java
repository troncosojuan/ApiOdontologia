package com.example.demo.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class PacienteDTO {

    private Long id;
    private String apellido;
    private String nombre;
    private String email;
    private Integer dni;
    private String fechaIngreso;
    private DomicilioDTO domicilio;

}

