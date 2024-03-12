package com.proyecto.restaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "el campo nombre es obligatorio")
    private String nombre;
    @NotNull(message = "la cantidad es obligatoria")
    private Integer cantidadIventario;
    @NotBlank(message = "debe ingresar la unidad de medida correspondiente")
    private String unidadMedida;


}
