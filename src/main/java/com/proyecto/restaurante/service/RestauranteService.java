package com.proyecto.restaurante.service;


import com.proyecto.restaurante.entity.Cliente;
import com.proyecto.restaurante.entity.Restaurante;
import com.proyecto.restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public void save(Restaurante rest){
        restauranteRepository.save(rest);
    }
    public List<Cliente> GetByName(String name) {

        return restauranteRepository.getByName("%" + name + "%");
    }
    public List<Restaurante> getAll(){
        return restauranteRepository.findAll();
    }

    public void delete(Long id) {
    restauranteRepository.deleteById(id);
    }
}
