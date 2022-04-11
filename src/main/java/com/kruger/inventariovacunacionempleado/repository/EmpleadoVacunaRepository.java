package com.kruger.inventariovacunacionempleado.repository;

import com.kruger.inventariovacunacionempleado.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmpleadoVacunaRepository extends CrudRepository<EmpleadoVacuna, Integer> {

    @Query("select c from EmpleadoVacuna c where c.idTipoVacuna = ?1")
    public List<EmpleadoVacuna> filtroTipoVacuna(TipoVacuna tipoVacuna);

    @Query("select c from EmpleadoVacuna c where c.fechaVacunacion between ?1 and ?2")
    public List<EmpleadoVacuna> filtroTipoFechas(Date fechaInicio, Date fechaFin);

    @Query("select c from EmpleadoVacuna c where c.idTipoVacuna = ?1 and c.idEmpleado.idEstadoVacunacion = ?2 and c.fechaVacunacion between ?3 and ?4")
    public List<EmpleadoVacuna> filtroTodos(TipoVacuna tipoVacuna, EstadoVacunacion estadoVacunacion, Date fechaInicio, Date fechaFin);
}