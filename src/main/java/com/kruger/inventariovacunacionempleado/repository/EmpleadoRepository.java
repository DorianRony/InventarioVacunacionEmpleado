package com.kruger.inventariovacunacionempleado.repository;

import com.kruger.inventariovacunacionempleado.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
    @Query("select c from Empleado c where c.idEstadoVacunacion = ?1")
    public List<Empleado> filtroTipoVacuna(EstadoVacunacion estadoVacunacion);
}