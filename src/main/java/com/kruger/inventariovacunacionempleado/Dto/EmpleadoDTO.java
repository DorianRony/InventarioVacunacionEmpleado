package com.kruger.inventariovacunacionempleado.Dto;

import com.kruger.inventariovacunacionempleado.entity.EstadoVacunacion;
import com.kruger.inventariovacunacionempleado.entity.Rol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Builder
public class EmpleadoDTO implements Serializable {
    private Integer idEmpleado;
    private String rol;
    private String estadoVacunacion;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String correo;
    private Date fecha_nacimiento;
    private String direccion_domicilio;
    private String telefono;
    private String usuario;
    private String password;
    private String mensaje;
    private Boolean guardado;
}
