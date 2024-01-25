package com.gestor.biblioteca.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestamos", schema = "biblioteca_java")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date fechaEntrega;
    private Date fechaVencimiento;
    private Date fechaDevolucion;

    public Prestamo() {
    }

    public Prestamo(Long id, Date fechaEntrega, Date fechaVencimiento, Date fechaDevolucion) {
        this.id = id;
        this.fechaEntrega = fechaEntrega;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
