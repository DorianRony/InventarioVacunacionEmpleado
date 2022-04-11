package com.kruger.inventariovacunacionempleado.controller;

import com.kruger.inventariovacunacionempleado.Dto.EmpleadoDTO;
import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.entity.Rol;
import com.kruger.inventariovacunacionempleado.service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    private EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @Operation(summary = "Lista empleados empleados")
    @GetMapping(path = "/listar", produces = "application/json")
    public List<Empleado> lista() {
        return empleadoService.lista();
    }

    @Operation(summary = "Realiza validaciones de datos y guarda el empleado empleado, genera el usuario")
    @PostMapping(path = "/guardar", produces = "application/json")
    public EmpleadoDTO guardar(@RequestBody @Validated Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    @Operation(summary = "actualiza el empleado")
    @PutMapping(path = "/actualizar", produces = "application/json")
    public EmpleadoDTO actualizar(@RequestBody @Validated Empleado empleado) {
        return empleadoService.actualizarEmpleado(empleado);
    }
}
