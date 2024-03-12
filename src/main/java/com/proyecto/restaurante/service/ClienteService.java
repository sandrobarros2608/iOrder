package com.proyecto.restaurante.service;

import com.proyecto.restaurante.entity.Cliente;
import com.proyecto.restaurante.entity.Restaurante;
import com.proyecto.restaurante.exception.ExistEmailException;
import com.proyecto.restaurante.exception.StringContainsNumberException;
import com.proyecto.restaurante.exception.UppercaseInStringException;
import com.proyecto.restaurante.repository.ClienteRepository;
import com.proyecto.restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Handler;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    public void save(Cliente cliente) {
        for (char c : cliente.getNombre().toCharArray()) { // hola-- h,o,l,a
            if (Character.isDigit(c)) {
                throw new StringContainsNumberException();
            }
        }
        for (char c : cliente.getPassword().toCharArray()) {
            if (!Character.isUpperCase(c)) {
                throw new UppercaseInStringException();
            } else {
                break;
            }
        }

        Optional<Cliente> cliente1 = clienteRepository.getByEmail(cliente.getEmail());
        if (cliente1.isPresent()) {
            throw new ExistEmailException();
        }

        clienteRepository.save(cliente);
    }


    public List<Cliente> GetAll() {
        return clienteRepository.findAll();
    }

    public List<Cliente> GetByName(String name) {
        return clienteRepository.getByName("%" + name + "%");
    }

    public void getByEmail(String email) {
        clienteRepository.getByEmail("%" + email + "%");
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
