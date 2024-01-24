package com.gestor.biblioteca.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor",schema = "biblioteca_java")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nopmbre;

    @Transient
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(Long id, String nopmbre, List<Libro> libros) {
        this.id = id;
        this.nopmbre = nopmbre;
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nopmbre;
    }

    public void setNopmbre(String nopmbre) {
        this.nopmbre = nopmbre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
