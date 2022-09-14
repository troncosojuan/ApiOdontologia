package com.example.demo.dto;


import lombok.Data;


@Data
public class PacienteDTO {

    //ID, Apellido, Nombre, Email, DNI, Fecha ingreso

    private Long id;
    private String apellido;
    private String nombre;
    private String email;
    private Integer dni;
    private String fechaIngreso;
    private DomicilioDTO domicilio;
}
