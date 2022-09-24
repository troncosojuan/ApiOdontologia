package com.example.demo.service;

import com.example.demo.dto.OdontologoDTO;
import com.example.demo.service.serviceInterface.OdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceImplTest {

    @Autowired
    private OdontologoService odontologoService;


    @Test
    public void testCrearOdontologo(){
        OdontologoDTO dto = new OdontologoDTO();
        dto.setApellido("Pepe");
        dto.setNombre("juan");
        dto.setMatricula("asdasd");
        odontologoService.save(dto);

        OdontologoDTO odontologoDTO = odontologoService.buscarPorID(3L);

        assertTrue(odontologoDTO != null);

    }

}