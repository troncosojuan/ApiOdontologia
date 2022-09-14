package com.example.demo.mapper;


import com.example.demo.dto.DomicilioDTO;
import com.example.demo.entity.DomicilioEntity;
import org.springframework.stereotype.Component;

@Component
public class DomicilioMap {

    public DomicilioEntity domicilioDTO2Entity(DomicilioDTO dto) {
        DomicilioEntity entity = new DomicilioEntity();
        entity.setCalle(dto.getCalle());
        entity.setNumero(dto.getNumero());
        entity.setLocalidad(dto.getLocalidad());
        entity.setProvincia(dto.getProvincia());
        return entity;
    }

    public DomicilioDTO domicilioEntity2DTO(DomicilioEntity entity) {
        DomicilioDTO dto = new DomicilioDTO();
        dto.setId(entity.getId());
        dto.setCalle(entity.getCalle());
        dto.setNumero(entity.getNumero());
        dto.setLocalidad(entity.getLocalidad());
        dto.setProvincia(entity.getProvincia());
        return dto;
    }
}
