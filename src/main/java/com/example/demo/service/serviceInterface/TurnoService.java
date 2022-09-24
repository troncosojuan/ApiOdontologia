package com.example.demo.service.serviceInterface;

import com.example.demo.dto.TurnoDTO;
import com.example.demo.dto.TurnoDTOBasic;

import java.util.List;

public interface TurnoService {


    void guardarTurno(TurnoDTOBasic dtoBasic);

    List<TurnoDTO> listarTurnos();

    void actualizarTurno(Long id, TurnoDTOBasic dto);

    TurnoDTO buscarTurno(Long id);

    void borrarTurno(Long id);
}
