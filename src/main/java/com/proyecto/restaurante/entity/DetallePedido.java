package com.proyecto.restaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "El campo comida no puede ser nulo")
    @ManyToOne
    private Comida comida;
    @NotNull(message = "se debe ingresar la cantidad a pedir")
    private Integer cantidadDeseada;

    @NotNull(message = "se debe especificar a que pedido hace referencia este detalle")
    @ManyToOne
    private Pedido pedido;
}
