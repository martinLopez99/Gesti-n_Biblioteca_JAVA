package com.gestor.biblioteca.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ejemplares",schema = "biblioteca_java")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int codigo;
    private Date fechaAlta;
    private Date fechaBaja;
    private boolean disponibilidad;

    public Ejemplar() {
    }

    public Ejemplar(Long id, int codigo, Date fechaAlta, Date fechaBaja, boolean disponibilidad) {
        this.id = id;
        this.codigo = codigo;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.disponibilidad = disponibilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
