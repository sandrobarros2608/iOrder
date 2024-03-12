package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.Pedido;
import com.proyecto.restaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/")
    public ResponseEntity<Boolean> savePedido(@Valid @RequestBody Pedido pedido){
        pedidoService.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/")
    public ResponseEntity<List<Pedido>> GetAllPedido() {
        List<Pedido> pd = pedidoService.getAll();
       return ResponseEntity.status(HttpStatus.OK).body(pd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        pedidoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
