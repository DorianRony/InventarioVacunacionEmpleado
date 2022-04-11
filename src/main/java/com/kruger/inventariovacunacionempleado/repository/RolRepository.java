package com.kruger.inventariovacunacionempleado.repository;

import com.kruger.inventariovacunacionempleado.entity.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
}