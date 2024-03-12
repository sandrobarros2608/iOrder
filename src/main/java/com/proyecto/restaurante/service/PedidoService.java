package com.proyecto.restaurante.service;


import com.proyecto.restaurante.entity.Comida;
import com.proyecto.restaurante.entity.DetallePedido;
import com.proyecto.restaurante.entity.DetalleReceta;
import com.proyecto.restaurante.entity.Pedido;
import com.proyecto.restaurante.repository.ComidaRepository;
import com.proyecto.restaurante.repository.DetalleRecetaRepository;
import com.proyecto.restaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetalleRecetaRepository detalleRecetaRepository;
    @Autowired
    private ComidaRepository comidaRepository;


    public void save(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }

    public void delete(Long id){
        pedidoRepository.deleteById(id);
    }
}
