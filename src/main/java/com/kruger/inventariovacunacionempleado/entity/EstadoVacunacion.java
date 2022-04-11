package com.kruger.inventariovacunacionempleado.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ESTADO_VACUNACION")
public class EstadoVacunacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO")
    private Integer idEstado;

    @Column(name = "NOMBRE_ESTADO")
    private String nombreEstado;
}
