package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class ListaDto {

    @NotBlank
    private String nombre;

    private String descripcion;

    public ListaDto() {
    }

    public ListaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ListaDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
