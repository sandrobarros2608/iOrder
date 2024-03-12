package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.Cliente;
import com.proyecto.restaurante.entity.Restaurante;
import com.proyecto.restaurante.service.RestauranteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/")
    public ResponseEntity<Boolean> saveRestaurante(@Valid @RequestBody Restaurante restaurante){
        restauranteService.save(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Cliente>> getById (@PathVariable String name){
        List<Cliente> Ls = restauranteService.GetByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(Ls);
    }

    @GetMapping("/")
    public ResponseEntity<List<Restaurante>> getAllRestaurante(){
        List<Restaurante> rs = restauranteService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(rs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        restauranteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
