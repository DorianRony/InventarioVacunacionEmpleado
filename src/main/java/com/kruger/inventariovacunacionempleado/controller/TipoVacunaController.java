package com.kruger.inventariovacunacionempleado.controller;

import com.kruger.inventariovacunacionempleado.entity.Rol;
import com.kruger.inventariovacunacionempleado.entity.TipoVacuna;
import com.kruger.inventariovacunacionempleado.service.RolService;
import com.kruger.inventariovacunacionempleado.service.TipoVacunaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipovacuna")
public class TipoVacunaController {
    private final TipoVacunaService tipoVacunaService;

    @Autowired
    private TipoVacunaController(TipoVacunaService tipoVacunaService){
        this.tipoVacunaService = tipoVacunaService;
    }

    @Operation(summary = "Lista tipo de vacuna de empleados")
    @GetMapping(path = "/listar", produces = "application/json")
    public List<TipoVacuna> lista() {
        return tipoVacunaService.lista();
    }

    @Operation(summary = "Guarda tipo de vacuna de empleados")
    @PostMapping(path = "/guardar", produces = "application/json")
    public TipoVacuna guardar(@RequestBody @Validated TipoVacuna tipoVacuna) {
        return tipoVacunaService.save(tipoVacuna);
    }

    @Operation(summary = "Actualizas tipo de vacuna de empleados")
    @PutMapping(path = "/actualizar", produces = "application/json")
    public void actualizar(@RequestBody @Validated TipoVacuna tipoVacuna) {
        tipoVacunaService.save(tipoVacuna);
    }
}
