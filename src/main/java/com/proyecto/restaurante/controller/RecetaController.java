package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.Receta;
import com.proyecto.restaurante.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @PostMapping("/")
    public ResponseEntity<Boolean> save(@RequestBody Receta receta) {
        recetaService.save(receta);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/")
    public ResponseEntity<List<Receta>> queryAll() {
        List<Receta> recetas = recetaService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(recetas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        recetaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
