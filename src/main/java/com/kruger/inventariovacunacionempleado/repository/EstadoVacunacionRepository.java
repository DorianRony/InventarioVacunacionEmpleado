package com.kruger.inventariovacunacionempleado.repository;

import com.kruger.inventariovacunacionempleado.entity.EstadoVacunacion;
import com.kruger.inventariovacunacionempleado.entity.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoVacunacionRepository extends CrudRepository<EstadoVacunacion, Integer> {
}