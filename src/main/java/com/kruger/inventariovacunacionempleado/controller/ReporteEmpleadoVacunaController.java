package com.kruger.inventariovacunacionempleado.controller;

import com.kruger.inventariovacunacionempleado.Dto.EmpleadoDTO;
import com.kruger.inventariovacunacionempleado.Dto.ReporteDTO;
import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.service.ReporteEmpleadoVacunaServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reporte")
public class ReporteEmpleadoVacunaController {

    private final ReporteEmpleadoVacunaServices reporteEmpleadoVacunaServices;

    @Autowired
    private ReporteEmpleadoVacunaController(ReporteEmpleadoVacunaServices reporteEmpleadoVacunaServices){
        this.reporteEmpleadoVacunaServices = reporteEmpleadoVacunaServices;
    }

    @Operation(summary = "Devuelve un objeto que contiene la lista de empleados filtrando por el tipo de vacuna")
    @GetMapping(path = "/reportetipovacuna", produces = "application/json")
    public ReporteDTO filtrarTipo(@RequestBody @Validated ReporteDTO reporteDTO) {
        return reporteEmpleadoVacunaServices.generarReporteTipoVacuna(reporteDTO);
    }

    @Operation(summary = "Devuelve un objeto que contiene la lista de empleados filtrando por el estado de vacunacion")
    @GetMapping(path = "/reporteestadovacunaempleado", produces = "application/json")
    public ReporteDTO filtrarEstado(@RequestBody @Validated ReporteDTO reporteDTO) {
        return reporteEmpleadoVacunaServices.generarReporteEstadoVacunacion(reporteDTO);
    }

    @Operation(summary = "Devuelve un objeto que contiene la lista de empleados filtrando por fechas de vacunacion")
    @GetMapping(path = "/reportefechasvacuna", produces = "application/json")
    public ReporteDTO filtrarFechas(@RequestBody @Validated ReporteDTO reporteDTO) {
        return reporteEmpleadoVacunaServices.generarReporteRangoFechasVacunacion(reporteDTO);
    }

    @Operation(summary = "Devuelve un objeto que contiene la lista de empleados filtrando por tio, fechas y estados")
    @GetMapping(path = "/reporteTodos", produces = "application/json")
    public ReporteDTO filtrarTodosFiltros(@RequestBody @Validated ReporteDTO reporteDTO) {
        return reporteEmpleadoVacunaServices.generarReporteTodosVacunacion(reporteDTO);
    }

}
