package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.Comida;
import com.proyecto.restaurante.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    private ComidaService comidaService;

    @PostMapping("/")
    public ResponseEntity<Boolean> saveComida(@Valid @RequestBody Comida comida){
        comidaService.save(comida);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }
    @GetMapping("/")
    public ResponseEntity<List<Comida>> getAllComida(){
        List<Comida> cmd = comidaService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(cmd);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        comidaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

