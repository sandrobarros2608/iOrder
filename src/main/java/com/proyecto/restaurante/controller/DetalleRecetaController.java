package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.DetalleReceta;
import com.proyecto.restaurante.service.DetalleRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleReceta")
public class DetalleRecetaController {

    @Autowired
    private DetalleRecetaService detalleRecetaService;

    @PostMapping("/")
    public ResponseEntity<Boolean> saveDR(@RequestBody DetalleReceta detalleReceta){
        detalleRecetaService.save(detalleReceta);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleReceta> GetById(@PathVariable Long id){
        DetalleReceta dr = detalleRecetaService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dr);
    }

    @GetMapping("/")
    public ResponseEntity<List<DetalleReceta>> GetAll(){
        List<DetalleReceta> Ldr = detalleRecetaService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(Ldr);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        detalleRecetaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
