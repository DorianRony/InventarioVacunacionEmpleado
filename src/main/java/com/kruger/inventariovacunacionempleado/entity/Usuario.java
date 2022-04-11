package com.kruger.inventariovacunacionempleado.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name="ID_ROL")
    private Rol idRol;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ESTADO")
    private Boolean estado;
}
