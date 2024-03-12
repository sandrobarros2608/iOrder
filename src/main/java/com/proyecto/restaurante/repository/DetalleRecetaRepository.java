package com.proyecto.restaurante.repository;

import com.proyecto.restaurante.entity.DetalleReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRecetaRepository extends JpaRepository<DetalleReceta, Long> {

}
