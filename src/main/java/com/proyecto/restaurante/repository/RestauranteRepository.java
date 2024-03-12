package com.proyecto.restaurante.repository;

import com.proyecto.restaurante.entity.Cliente;
import com.proyecto.restaurante.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    @Query("SELECT r FROM Restaurante r WHERE nombre LIKE ?1")
    public List<Cliente> getByName(String nombre);
}
