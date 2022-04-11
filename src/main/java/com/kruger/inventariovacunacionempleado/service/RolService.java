package com.kruger.inventariovacunacionempleado.service;

import com.kruger.inventariovacunacionempleado.entity.Rol;
import com.kruger.inventariovacunacionempleado.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> lista() {
       return (List<Rol>) rolRepository.findAll();
    }
    public Rol findbyId (Integer id){
       return rolRepository.findById(id).get();
    }
    public Rol save(Rol rol){
        return rolRepository.save(rol);
    }
    public void delete(Rol rol){
        rolRepository.delete(rol);
    }
}