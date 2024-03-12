package com.proyecto.restaurante.service;

import com.proyecto.restaurante.entity.Comida;
import com.proyecto.restaurante.repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    public void save(Comida comida){
        comidaRepository.save(comida);
    }

    public List<Comida> getAll(){
       return comidaRepository.findAll();
    }

    public void delete(Long id){
        comidaRepository.deleteById(id);
    }
}
