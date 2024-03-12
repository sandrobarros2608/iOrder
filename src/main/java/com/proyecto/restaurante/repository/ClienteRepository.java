package com.proyecto.restaurante.repository;

import com.proyecto.restaurante.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE nombre LIKE ?1")
    public List<Cliente> getByName(String nombre);

    @Query(value = "SELECT * FROM Cliente WHERE email LIKE ?1", nativeQuery = true)
    Optional<Cliente> getByEmail(String email);
}
