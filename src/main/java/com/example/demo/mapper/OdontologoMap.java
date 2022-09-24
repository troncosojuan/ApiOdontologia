package com.example.demo.mapper;

import com.example.demo.dto.DomicilioDTO;
import com.example.demo.dto.OdontologoDTO;
import com.example.demo.entity.DomicilioEntity;
import com.example.demo.entity.OdontologoEntity;
import org.springframework.stereotype.Component;

@Component
public class OdontologoMap {

    public OdontologoEntity odontologoDTO2Entity(OdontologoDTO dto) {
        OdontologoEntity entity = new OdontologoEntity();
        entity.setApellido(dto.getApellido());
        entity.setNombre(dto.getNombre());
        entity.setMatricula(dto.getMatricula());
        return entity;
    }

    public OdontologoDTO odontologoEntity2DTO(OdontologoEntity entity) {
        OdontologoDTO dto = new OdontologoDTO();
        dto.setId(entity.getId());
        dto.setApellido(entity.getApellido());
        dto.setNombre(entity.getNombre());
        dto.setMatricula(entity.getMatricula());
        return dto;
    }
}
