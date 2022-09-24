package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TurnoDTO {

    private Long id;
    private LocalDate fechaCreacion;
    private OdontologoDTO odontologoDTO;
    private PacienteDTO pacienteDTO;

}
