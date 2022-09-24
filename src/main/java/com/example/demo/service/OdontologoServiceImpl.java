package com.example.demo.service;

import com.example.demo.dto.OdontologoDTO;
import com.example.demo.entity.OdontologoEntity;
import com.example.demo.exception.ParamNotFound;
import com.example.demo.mapper.OdontologoMap;
import com.example.demo.repository.OdontologoRepository;
import com.example.demo.service.serviceInterface.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    @Autowired
    private OdontologoMap odontologoMap;
    @Autowired
    private OdontologoRepository odontologoRepository;

    @Override
    public OdontologoDTO save(OdontologoDTO dto) {
        OdontologoEntity entity = odontologoMap.odontologoDTO2Entity(dto);
        OdontologoEntity odontologoGuardado = odontologoRepository.save(entity);
        OdontologoDTO odontologoDTO = odontologoMap.odontologoEntity2DTO(odontologoGuardado);
        return odontologoDTO;
    }

    @Override
    public OdontologoDTO buscarPorID(Long id) throws ParamNotFound {
        if (!odontologoRepository.existsById(id)){
            throw new ParamNotFound("id incorrecto o no existe");
        }
        OdontologoEntity entity = odontologoRepository.findById(id).get();
        OdontologoDTO dto = odontologoMap.odontologoEntity2DTO(entity);
        return dto;
    }

    @Override
    public void borrarPaciente(Long id) throws ParamNotFound {
        if (!odontologoRepository.existsById(id)){
            throw new ParamNotFound("id incorrecto o no existe");
        }
        OdontologoEntity entity = odontologoRepository.findById(id).get();
        odontologoRepository.delete(entity);
    }

    @Override
    public List<OdontologoDTO> listarTodosLosPacientes() {
        List<OdontologoDTO> listaOdontologos = new ArrayList<>();
        for (OdontologoEntity entity : odontologoRepository.findAll()){
            OdontologoDTO odontologoDto = odontologoMap.odontologoEntity2DTO(entity);
            listaOdontologos.add(odontologoDto);
        }
        return listaOdontologos;
    }

    @Override
    public void update(OdontologoDTO dto, Long id) throws ParamNotFound {
        if (!odontologoRepository.existsById(id)){
            throw new ParamNotFound("id incorrecto o no existe");
        }
        OdontologoEntity entity = odontologoMap.odontologoDTO2Entity(dto);
        entity.setId(id);
        odontologoRepository.save(entity);
    }
}
