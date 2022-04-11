package com.kruger.inventariovacunacionempleado.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TIPO_VACUNA")
public class TipoVacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO")
    private Integer idTipo;

    @Column(name = "NOMBRE_TIPO")
    private String nombreTipo;
}
