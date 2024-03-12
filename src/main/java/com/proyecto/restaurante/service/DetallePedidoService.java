package com.proyecto.restaurante.service;

import com.proyecto.restaurante.entity.Comida;
import com.proyecto.restaurante.entity.DetallePedido;
import com.proyecto.restaurante.entity.DetalleReceta;
import com.proyecto.restaurante.exception.EmptyInventoryException;
import com.proyecto.restaurante.exception.IdComidaNotFoundException;
import com.proyecto.restaurante.repository.ComidaRepository;
import com.proyecto.restaurante.repository.DetallePedidoRepository;
import com.proyecto.restaurante.repository.DetalleRecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private DetalleRecetaRepository detalleRecetaRepository;
    @Autowired
    private ComidaRepository comidaRepository;

    public void save(DetallePedido detallePedido) {

        Optional<Comida> p2 = comidaRepository.findById(detallePedido.getComida().getId());
        if (p2.isPresent()) {
            List<DetalleReceta> dr = p2.get().getReceta().getDetalleReceta();
            for (DetalleReceta dr2 : dr) {
                if (dr2.getInventario().getCantidadIventario() >= (dr2.getCantidadRequerida() * detallePedido.getCantidadDeseada())) {
                    dr2.getInventario().setCantidadIventario(dr2.getInventario().getCantidadIventario() - (dr2.getCantidadRequerida() * detallePedido.getCantidadDeseada()));
                    detalleRecetaRepository.save(dr2);
                } else {
                    throw new EmptyInventoryException();
                }
            }
        }else{
            throw new IdComidaNotFoundException("id de comida {"+detallePedido.getComida().getId()+"} no existe");
        }
        detallePedidoRepository.save(detallePedido);
    }



    public List<DetallePedido> getAll() {
        return detallePedidoRepository.findAll();
    }

    public void delete(Long id) {
        detallePedidoRepository.deleteById(id);
    }
}
