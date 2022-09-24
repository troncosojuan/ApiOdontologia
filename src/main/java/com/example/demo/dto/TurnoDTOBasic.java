package com.example.demo.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data

public class TurnoDTOBasic {
    private Long idOdontologo;
    private Long idPaciente;
    private String fechaCreacion;
}
