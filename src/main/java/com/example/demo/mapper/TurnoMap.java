package com.example.demo.mapper;


import com.example.demo.dto.TurnoDTO;
import com.example.demo.dto.TurnoDTOBasic;
import com.example.demo.entity.TurnoEntity;
import com.example.demo.repository.OdontologoRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TurnoMap {

    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private PacienteMap pacienteMap;
    @Autowired
    private OdontologoMap odontologoMap;
    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    public TurnoEntity turnoDTOBasic2Entity(TurnoDTOBasic dtoBasic) {
        TurnoEntity entity = new TurnoEntity();

        entity.setOdontologoId(dtoBasic.getIdOdontologo());
        entity.setPacienteId(dtoBasic.getIdPaciente());
        entity.setFechaCreacion(LocalDate.parse(dtoBasic.getFechaCreacion(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return entity;
    }

    public TurnoDTO turnoEntity2DTO(TurnoEntity entity){
        TurnoDTO dto = new TurnoDTO();
        dto.setId(entity.getId());
        dto.setOdontologoDTO(odontologoMap.odontologoEntity2DTO(entity.getOdontologo()));
        dto.setPacienteDTO(pacienteMap.pacienteEntity2DTO(entity.getPaciente()));
        dto.setFechaCreacion(entity.getFechaCreacion());
        return dto;
    }


}
