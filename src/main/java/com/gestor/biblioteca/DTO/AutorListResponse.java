package com.gestor.biblioteca.DTO;

import com.gestor.biblioteca.Entities.Libro;

import java.util.List;

public class AutorListResponse {

    private String nombre;
    private List<Libro> libros;

    public AutorListResponse() {
    }

    public AutorListResponse(String nombre, List<Libro> libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
