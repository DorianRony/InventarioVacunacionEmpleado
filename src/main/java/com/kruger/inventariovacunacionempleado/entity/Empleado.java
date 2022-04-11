package com.kruger.inventariovacunacionempleado.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "EMPLEADO")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idEmpleado;

    @ManyToOne
    @JoinColumn(name="ID_ESTADOVACUNACION")
    private EstadoVacunacion idEstadoVacunacion;

    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario idUsuario;

    @Column(name = "CEDULA")
    private String cedula;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fecha_nacimiento;

    @Column(name = "DIRECCION_DOMICILIO")
    private String direccion_domicilio;

    @Column(name = "TELEFONO")
    private String telefono;
}
