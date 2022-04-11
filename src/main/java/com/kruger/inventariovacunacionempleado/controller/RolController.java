package com.kruger.inventariovacunacionempleado.controller;

import com.kruger.inventariovacunacionempleado.entity.EstadoVacunacion;
import com.kruger.inventariovacunacionempleado.entity.Rol;
import com.kruger.inventariovacunacionempleado.service.EstadoVacunacionService;
import com.kruger.inventariovacunacionempleado.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {
    private final RolService rolService;

    private RolController(RolService rolService){
        this.rolService = rolService;
    }

    @Operation(summary = "Lista Roles de empleados")
    @GetMapping(path = "/listar", produces = "application/json")
    public List<Rol> lista() {
        return rolService.lista();
    }

    @Operation(summary = "Guarda informacion de roles de empleado")
    @PostMapping(path = "/guardar", produces = "application/json")
    public Rol guardar(@RequestBody @Validated Rol estadoVacunacion) {
        return rolService.save(estadoVacunacion);
    }

    @Operation(summary = "Actualiza informacion de roles de empleado")
    @PutMapping(path = "/actualizar", produces = "application/json")
    public void actualizar(@RequestBody @Validated Rol estadoVacunacion) {
        rolService.save(estadoVacunacion);
    }
}
