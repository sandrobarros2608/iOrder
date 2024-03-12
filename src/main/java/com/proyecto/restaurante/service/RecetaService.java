package com.proyecto.restaurante.service;

import com.proyecto.restaurante.entity.Receta;
import com.proyecto.restaurante.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    public void save(Receta receta) {
        recetaRepository.save(receta);
    }

    public List<Receta> getAll() {
        return recetaRepository.findAll();
    }
    public void deleteById(Long id) {
        recetaRepository.deleteById(id);
    }
}
