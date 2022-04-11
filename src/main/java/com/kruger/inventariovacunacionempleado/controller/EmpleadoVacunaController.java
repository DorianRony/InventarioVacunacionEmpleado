package com.kruger.inventariovacunacionempleado.controller;

import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.entity.EmpleadoVacuna;
import com.kruger.inventariovacunacionempleado.service.EmpleadoService;
import com.kruger.inventariovacunacionempleado.service.EmpleadoVacunaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleadovacuna")
public class EmpleadoVacunaController {
    private final EmpleadoVacunaService empleadoVacunaService;

    @Autowired
    private EmpleadoVacunaController(EmpleadoVacunaService empleadoVacunaService){
        this.empleadoVacunaService = empleadoVacunaService;
    }

    @Operation(summary = "Guarda informacion de empleados vacunados")
    @PostMapping(path = "/guardar", produces = "application/json")
    public EmpleadoVacuna guardar(@RequestBody @Validated EmpleadoVacuna empleadoVacuna) {
        return empleadoVacunaService.save(empleadoVacuna);
    }

    @Operation(summary = "actualiza informacion de empleados vacunados")
    @PutMapping(path = "/actualizar", produces = "application/json")
    public void actualizar(@RequestBody @Validated EmpleadoVacuna empleadoVacuna) {
        empleadoVacunaService.save(empleadoVacuna);
    }
}
