package com.example.demo.controller;

import com.example.demo.dto.TurnoDTO;
import com.example.demo.dto.TurnoDTOBasic;
import com.example.demo.service.TurnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoServiceImpl turnoServiceImpl;

    @PostMapping
    private ResponseEntity generarTurno(@RequestBody TurnoDTOBasic dtoBasic){
        turnoServiceImpl.guardarTurno(dtoBasic);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping
    private ResponseEntity<List<TurnoDTO>> listaDeTurnos(){
        List<TurnoDTO> lista = turnoServiceImpl.listarTurnos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PutMapping("/{id}")
    private ResponseEntity actualizarTurno(@PathVariable ("id") Long id, @RequestBody TurnoDTOBasic dto){
        turnoServiceImpl.actualizarTurno(id, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<TurnoDTO> buscarTurno (@PathVariable ("id") Long id){
        TurnoDTO turnoDTO = turnoServiceImpl.buscarTurno(id);
        return ResponseEntity.status(HttpStatus.OK).body(turnoDTO);
    }

     @DeleteMapping("/{id}")
    private ResponseEntity borrarTurno (@PathVariable ("id") Long id){
        turnoServiceImpl.borrarTurno(id);
        return ResponseEntity.status(HttpStatus.OK).build();
     }





}
