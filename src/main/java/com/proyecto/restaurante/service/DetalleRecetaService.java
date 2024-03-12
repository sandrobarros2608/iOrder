package com.proyecto.restaurante.service;

import com.proyecto.restaurante.entity.DetalleReceta;
import com.proyecto.restaurante.repository.DetalleRecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleRecetaService {

    @Autowired
    private DetalleRecetaRepository detalleRecetaRepository;

    public void save(DetalleReceta detalleReceta){
        detalleRecetaRepository.save(detalleReceta);
    }

    public DetalleReceta getById(Long id){
       return detalleRecetaRepository.getReferenceById(id);
    }

    public List<DetalleReceta> getAll(){
        return detalleRecetaRepository.findAll();
    }

    public void delete(Long id){
        detalleRecetaRepository.deleteById(id);
    }
}
