package com.example.demo.mapper;

import com.example.demo.dto.DomicilioDTO;
import com.example.demo.dto.PacienteDTO;
import com.example.demo.entity.DomicilioEntity;
import com.example.demo.entity.PacienteEntity;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteMap {

    @Autowired
    private DomicilioMap domicilioMap;
    @Autowired
    private PacienteRepository pacienteRepository;
    // DTO 2 Entity
    public PacienteEntity pacienteDTO2Entity(PacienteDTO dto) {
        PacienteEntity entity = new PacienteEntity();

        entity.setApellido(dto.getApellido());
        entity.setNombre(dto.getNombre());
        entity.setEmail(dto.getEmail());
        entity.setFechaIngreso(LocalDate.parse(dto.getFechaIngreso(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        entity.setDomicilio(domicilioMap.domicilioDTO2Entity(dto.getDomicilio()));
        return entity;
    }



    // Entity 2 DTO
    public PacienteDTO pacienteEntity2DTO(PacienteEntity entity) {
        PacienteDTO dto = new PacienteDTO();
        dto.setId(entity.getId());
        dto.setApellido(entity.getApellido());
        dto.setNombre(entity.getNombre());
        dto.setEmail(entity.getEmail());
        dto.setDni(entity.getDni());
        dto.setFechaIngreso(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(entity.getFechaIngreso()));
        dto.setDomicilio(domicilioMap.domicilioEntity2DTO(entity.getDomicilio()));
        return dto;
    }

    public List<PacienteDTO> pacienteEntityList2DTOList() {
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();
        for (PacienteEntity entity : pacienteRepository.findAll()){
            pacienteDTOList.add(pacienteEntity2DTO(entity));
        }
        return pacienteDTOList;
    }
}
