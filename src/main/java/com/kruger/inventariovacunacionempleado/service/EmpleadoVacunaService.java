package com.kruger.inventariovacunacionempleado.service;

import com.kruger.inventariovacunacionempleado.entity.Empleado;
import com.kruger.inventariovacunacionempleado.entity.EmpleadoVacuna;
import com.kruger.inventariovacunacionempleado.repository.EmpleadoRepository;
import com.kruger.inventariovacunacionempleado.repository.EmpleadoVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoVacunaService {
    private final EmpleadoVacunaRepository empleadoVacunaRepository;

    @Autowired
    public EmpleadoVacunaService(EmpleadoVacunaRepository empleadoVacunaRepository) {
        this.empleadoVacunaRepository = empleadoVacunaRepository;
    }

    public List<EmpleadoVacuna> lista() {
       return (List<EmpleadoVacuna>) empleadoVacunaRepository.findAll();
    }
    public EmpleadoVacuna findbyId (Integer id){
       return empleadoVacunaRepository.findById(id).get();
    }
    public EmpleadoVacuna save(EmpleadoVacuna rol){
        return empleadoVacunaRepository.save(rol);
    }
    public void delete(EmpleadoVacuna rol){
        empleadoVacunaRepository.delete(rol);
    }
}