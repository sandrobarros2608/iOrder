package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.DetallePedido;
import com.proyecto.restaurante.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping("/")
    public ResponseEntity<Boolean> save(@Valid @RequestBody DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/")
    public ResponseEntity<List<DetallePedido>> queryAll() {
        List<DetallePedido> dp = detallePedidoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(dp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        detallePedidoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

