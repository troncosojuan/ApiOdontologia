package com.example.demo.controller;


import com.example.demo.dto.OdontologoDTO;
import com.example.demo.service.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoServiceImpl odontologoServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontologoPorId(@PathVariable("id") Long id) {
        OdontologoDTO odontologoDTO = odontologoServiceImpl.buscarPorID(id);
        return ResponseEntity.status(HttpStatus.OK).body(odontologoDTO);
    }

    @PostMapping
    public ResponseEntity registrarOdontologo(@RequestBody OdontologoDTO dto) {
        OdontologoDTO odontologoDTO = odontologoServiceImpl.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(odontologoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarOdontologo(@RequestBody OdontologoDTO dto, @PathVariable("id") Long id) {
        odontologoServiceImpl.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarOdontologo(@PathVariable("id") Long id) {
        odontologoServiceImpl.borrarPaciente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> listarOdontologos() {
        List<OdontologoDTO> lista = odontologoServiceImpl.listarTodosLosPacientes();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }


}
