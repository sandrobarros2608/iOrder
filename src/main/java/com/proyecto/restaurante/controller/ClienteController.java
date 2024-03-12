package com.proyecto.restaurante.controller;

import com.proyecto.restaurante.entity.Cliente;
import com.proyecto.restaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<Boolean> saveCliente(@Valid @RequestBody Cliente cliente){
        clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> getAllCliente(){
         List<Cliente> ls = clienteService.GetAll();
        return ResponseEntity.status(HttpStatus.OK).body(ls);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Cliente>> getById (@PathVariable String name){
        List<Cliente> Ls = clienteService.GetByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(Ls);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
