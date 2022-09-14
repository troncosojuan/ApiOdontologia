package com.example.demo.servicio;


import com.example.demo.dto.PacienteDTO;
import com.example.demo.entity.PacienteEntity;
import com.example.demo.exception.ParamNotFound;
import com.example.demo.mapper.PacienteMap;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.servicio.serviceInterface.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteMap pacienteMap;

    @Override
    public PacienteDTO save(PacienteDTO dto){
        PacienteEntity entity = pacienteMap.pacienteDTO2Entity(dto);
        pacienteRepository.save(entity);
        PacienteDTO pacienteCreado = pacienteMap.pacienteEntity2DTO(entity);
        return pacienteCreado;
    }

    @Override
    public PacienteDTO buscarPorID(Long id) {
        PacienteEntity pacienteEncontrado = pacienteRepository.findById(id).orElseThrow(() -> new ParamNotFound("no se encuentra el id del paciente"));
        PacienteDTO pacienteDTO = pacienteMap.pacienteEntity2DTO(pacienteEncontrado);
        return pacienteDTO;
    }

    @Override
    public void borrarPaciente(Long id) {
        PacienteEntity pacienteEncontrado = pacienteRepository.findById(id).orElseThrow(() -> new ParamNotFound("no se encuentra el id del paciente"));
        pacienteRepository.delete(pacienteEncontrado);
    }

    @Override
    public List<PacienteDTO> listarTodosLosPacientes() {
        List<PacienteDTO> pacientes = pacienteMap.pacienteEntityList2DTOList();
        return pacientes;
    }


}
