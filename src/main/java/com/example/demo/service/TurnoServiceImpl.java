package com.example.demo.service;

import com.example.demo.dto.TurnoDTO;
import com.example.demo.dto.TurnoDTOBasic;
import com.example.demo.entity.TurnoEntity;
import com.example.demo.exception.ParamNotFound;
import com.example.demo.mapper.TurnoMap;
import com.example.demo.repository.OdontologoRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.TurnoRepository;
import com.example.demo.service.serviceInterface.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private TurnoMap turnoMap;


    @Override
    public void guardarTurno(TurnoDTOBasic dtoBasic) {
        List<TurnoEntity> lista = turnoRepository.obtenerTurnoDisponibleConOdontologoYFecha(dtoBasic.getIdOdontologo(), fechastring2LocaldateYVerificacion(dtoBasic.getFechaCreacion()));

        if (!odontologoRepository.existsById(dtoBasic.getIdOdontologo()) && !pacienteRepository.existsById(dtoBasic.getIdPaciente())) {
            throw new ParamNotFound("id incorrecto o no existe");
        } else if (!lista.isEmpty()) {
            throw new ParamNotFound("Error con fecha de turno con odontologo");
        }
        TurnoEntity entity = turnoMap.turnoDTOBasic2Entity(dtoBasic);
        turnoRepository.save(entity);

    }

    public LocalDate fechastring2LocaldateYVerificacion(String fecha) {
        LocalDate date = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (!date.isAfter(LocalDate.now())) {
            throw new RuntimeException("La fecha tiene que ser mas adelante");
        }
        return date;
    }

    @Override
    public List<TurnoDTO> listarTurnos() {
        List<TurnoDTO> lista = new ArrayList<>();
        for (TurnoEntity turno : turnoRepository.findAll()) {
            TurnoDTO dto = turnoMap.turnoEntity2DTO(turno);
            lista.add(dto);
        }
        return lista;
    }

    @Override
    public void actualizarTurno(Long id, TurnoDTOBasic dto) {
        if (!turnoRepository.existsById(id)) {
            throw new ParamNotFound("id incorrecto o no existe");
        }
        TurnoEntity entity = new TurnoEntity();
        entity.setId(id);
        entity.setFechaCreacion(LocalDate.parse(dto.getFechaCreacion(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        turnoRepository.save(entity);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        if (!turnoRepository.existsById(id)) {
            throw new ParamNotFound("id incorrecto o no existe");
        }
        TurnoDTO dto = turnoMap.turnoEntity2DTO(turnoRepository.findById(id).get());
        return dto;
    }

    @Override
    public void borrarTurno(Long id) {
        if (!turnoRepository.existsById(id)) {
            throw new ParamNotFound("id incorrecto o no existe");
        }
        turnoRepository.deleteById(id);
    }
}
