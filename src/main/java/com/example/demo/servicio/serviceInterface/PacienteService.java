package com.example.demo.servicio.serviceInterface;


import com.example.demo.dto.PacienteDTO;

import java.util.List;

public interface PacienteService {

    PacienteDTO save(PacienteDTO dto);

    PacienteDTO buscarPorID(Long id);

    void borrarPaciente(Long id);

    List<PacienteDTO> listarTodosLosPacientes();





}
