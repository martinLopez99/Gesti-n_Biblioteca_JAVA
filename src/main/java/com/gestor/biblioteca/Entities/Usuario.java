package com.gestor.biblioteca.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios",schema = "biblioteca_java")
public class Usuario extends Persona{

    private int score;
    @Transient
    private List<Libro> librosPrestados;

    public Usuario() {
    }

    public Usuario(int score, List<Libro> librosPrestados) {
        this.score = score;
        this.librosPrestados = librosPrestados;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
}
