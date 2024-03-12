package com.proyecto.restaurante.controller;


import com.proyecto.restaurante.entity.Inventario;
import com.proyecto.restaurante.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping("/")
    public ResponseEntity<Boolean> savePedido(@RequestBody Inventario inventario){
        inventarioService.save(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/")
    public ResponseEntity<List<Inventario>> GetAllPedido() {
        List<Inventario> pd = inventarioService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(pd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        inventarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
