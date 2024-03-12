package com.proyecto.restaurante.service;

import com.proyecto.restaurante.entity.Inventario;
import com.proyecto.restaurante.exception.AmountNegativeException;
import com.proyecto.restaurante.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public void save(Inventario inventario){
        if(inventario.getCantidadIventario() < 0){
            throw new AmountNegativeException();
        }
        inventarioRepository.save(inventario);
    }

    public List<Inventario> getAll(){
        return inventarioRepository.findAll();
    }

    public void delete(Long id){
        inventarioRepository.deleteById(id);
    }
}
