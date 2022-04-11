package com.kruger.inventariovacunacionempleado.service;

import com.kruger.inventariovacunacionempleado.entity.TipoVacuna;
import com.kruger.inventariovacunacionempleado.repository.TipoVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVacunaService {
    private final TipoVacunaRepository tipoVacunaRepository;

    @Autowired
    public TipoVacunaService(TipoVacunaRepository tipoVacunaRepository) {
        this.tipoVacunaRepository = tipoVacunaRepository;
    }

    public List<TipoVacuna> lista() {
       return (List<TipoVacuna>) tipoVacunaRepository.findAll();
    }
    public TipoVacuna findbyId (Integer id){
       return tipoVacunaRepository.findById(id).get();
    }
    public TipoVacuna save(TipoVacuna tipoVacuna){
        return tipoVacunaRepository.save(tipoVacuna);
    }
    public void delete(TipoVacuna tipoVacuna){
        tipoVacunaRepository.delete(tipoVacuna);
    }
}