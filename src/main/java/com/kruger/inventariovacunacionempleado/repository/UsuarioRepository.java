package com.kruger.inventariovacunacionempleado.repository;

import com.kruger.inventariovacunacionempleado.entity.Rol;
import com.kruger.inventariovacunacionempleado.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}