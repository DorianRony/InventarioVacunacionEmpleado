package com.kruger.inventariovacunacionempleado.Dto;

import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.entity.EstadoVacunacion;
import com.kruger.inventariovacunacionempleado.entity.TipoVacuna;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class ReporteDTO {
    private EstadoVacunacion estadoVacunacion;
    private TipoVacuna tipoVacuna;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Empleado> empleados;
}
