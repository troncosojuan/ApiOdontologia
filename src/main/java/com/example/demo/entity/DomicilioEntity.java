package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "domicilio")
public class DomicilioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

}


