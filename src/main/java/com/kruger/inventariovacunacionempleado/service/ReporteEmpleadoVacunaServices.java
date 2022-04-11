package com.kruger.inventariovacunacionempleado.service;

import com.kruger.inventariovacunacionempleado.Dto.ReporteDTO;
import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.entity.EmpleadoVacuna;
import com.kruger.inventariovacunacionempleado.repository.EmpleadoRepository;
import com.kruger.inventariovacunacionempleado.repository.EmpleadoVacunaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReporteEmpleadoVacunaServices {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoVacunaRepository empleadoVacunaRepository;

    private ReporteEmpleadoVacunaServices(EmpleadoRepository empleadoRepository,EmpleadoVacunaRepository empleadoVacunaRepository){
        this.empleadoRepository = empleadoRepository;
        this.empleadoVacunaRepository = empleadoVacunaRepository;
    }


    public ReporteDTO generarReporteEstadoVacunacion(ReporteDTO reporteDTO){
        List<Empleado> empleados = empleadoRepository.filtroTipoVacuna(reporteDTO.getEstadoVacunacion());
        reporteDTO.setEmpleados(empleados);
        return reporteDTO;
    }

    public ReporteDTO generarReporteTipoVacuna(ReporteDTO reporteDTO){
        List<Empleado> empleados = empleadoVacunaRepository.filtroTipoVacuna(reporteDTO.getTipoVacuna())
                .stream().map(EmpleadoVacuna::getIdEmpleado).collect(Collectors.toList());
        reporteDTO.setEmpleados(empleados);
        return reporteDTO;
    }

    public ReporteDTO generarReporteRangoFechasVacunacion(ReporteDTO reporteDTO){
        List<Empleado> empleados = empleadoVacunaRepository.filtroTipoFechas(reporteDTO.getFechaInicio(),reporteDTO.getFechaFin())
                .stream().map(EmpleadoVacuna::getIdEmpleado).collect(Collectors.toList());
        reporteDTO.setEmpleados(empleados);
        return reporteDTO;
    }

    public ReporteDTO generarReporteTodosVacunacion(ReporteDTO reporteDTO){
        List<Empleado> empleados = empleadoVacunaRepository.filtroTodos(reporteDTO.getTipoVacuna(),reporteDTO.getEstadoVacunacion(),reporteDTO.getFechaInicio(),reporteDTO.getFechaFin())
                .stream().map(EmpleadoVacuna::getIdEmpleado).collect(Collectors.toList());
        reporteDTO.setEmpleados(empleados);
        return reporteDTO;
    }
}
