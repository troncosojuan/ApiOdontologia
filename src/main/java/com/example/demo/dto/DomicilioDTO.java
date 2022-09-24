package com.example.demo.dto;


import lombok.Data;

@Data

public class DomicilioDTO {

    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
