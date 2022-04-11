package com.kruger.inventariovacunacionempleado.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "EMPLEADOVACUNA")
public class EmpleadoVacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLEADOVACUNA")
    private Integer idEmpleadoVacuna;

    @ManyToOne
    @JoinColumn(name="ID_TIPOVACUNA")
    private TipoVacuna idTipoVacuna;

    @ManyToOne
    @JoinColumn(name="ID")
    private Empleado idEmpleado;

    @Column(name = "FECHA_VACUNACION")
    private Date fechaVacunacion;

    @Column(name = "NUMERO_DOSIS")
    private int numeroDosis;
}
