package com.kruger.inventariovacunacionempleado.controller;

import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.entity.EstadoVacunacion;
import com.kruger.inventariovacunacionempleado.service.EmpleadoService;
import com.kruger.inventariovacunacionempleado.service.EstadoVacunacionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadovacunacion")
public class EstadoVacunacionController {
    private final EstadoVacunacionService estadoVacunacionService;
    @Autowired
    private EstadoVacunacionController(EstadoVacunacionService estadoVacunacionService){
        this.estadoVacunacionService = estadoVacunacionService;
    }

    @Operation(summary = "Lista los estados de vacunacion")
    @GetMapping(path = "/listar", produces = "application/json")
    public List<EstadoVacunacion> lista() {
        return estadoVacunacionService.lista();
    }

    @Operation(summary = "Guarda estados de vacunacion")
    @PostMapping(path = "/guardar", produces = "application/json")
    public EstadoVacunacion guardar(@RequestBody @Validated EstadoVacunacion estadoVacunacion) {
        return estadoVacunacionService.save(estadoVacunacion);
    }

    @Operation(summary = "Actualiza informacion de empleados vacunados")
    @PutMapping(path = "/actualizar", produces = "application/json")
    public void actualizar(@RequestBody @Validated EstadoVacunacion estadoVacunacion) {
        estadoVacunacionService.save(estadoVacunacion);
    }
}
