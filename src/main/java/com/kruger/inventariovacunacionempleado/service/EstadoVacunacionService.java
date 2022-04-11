package com.kruger.inventariovacunacionempleado.service;

import com.kruger.inventariovacunacionempleado.entity.EstadoVacunacion;
import com.kruger.inventariovacunacionempleado.repository.EstadoVacunacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoVacunacionService {
    private final EstadoVacunacionRepository estadoVacunacionRepository;

    @Autowired
    public EstadoVacunacionService(EstadoVacunacionRepository estadoVacunacionRepository) {
        this.estadoVacunacionRepository = estadoVacunacionRepository;
    }

    public List<EstadoVacunacion> lista() {
       return (List<EstadoVacunacion>) estadoVacunacionRepository.findAll();
    }
    public EstadoVacunacion findbyId (Integer id){
       return estadoVacunacionRepository.findById(id).get();
    }
    public EstadoVacunacion save(EstadoVacunacion rol){
        return estadoVacunacionRepository.save(rol);
    }
    public void delete(EstadoVacunacion rol){
        estadoVacunacionRepository.delete(rol);
    }
}