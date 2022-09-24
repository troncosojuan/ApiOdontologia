package com.example.demo.service.serviceInterface;


import com.example.demo.dto.OdontologoDTO;

import java.util.List;

public interface OdontologoService {

    OdontologoDTO save(OdontologoDTO dto);

    OdontologoDTO buscarPorID(Long id);

    void borrarPaciente(Long id);

    List<OdontologoDTO> listarTodosLosPacientes();

    void update(OdontologoDTO dto, Long id);

}
