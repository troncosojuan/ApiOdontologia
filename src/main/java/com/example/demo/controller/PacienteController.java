package com.example.demo.controller;

import com.example.demo.dto.PacienteDTO;
import com.example.demo.servicio.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> crearPaciente(@RequestBody PacienteDTO dto){
        PacienteDTO pacienteDTOGuardado = pacienteService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDTOGuardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPacientePorID(@PathVariable("id") Long id){
        PacienteDTO pacienteDTO = pacienteService.buscarPorID(id);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarPacientePorId(@PathVariable("id") Long id){
        pacienteService.borrarPaciente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> buscarTodosLosPacientes(){
        List<PacienteDTO> pacientesDTO = pacienteService.listarTodosLosPacientes();
        return ResponseEntity.status(HttpStatus.OK).body(pacientesDTO);
    }



}
