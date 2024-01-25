package com.gestor.biblioteca.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notificacion", schema = "biblioteca_java")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date fechaDeEnvio;

    public Notificacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaDeEnvio() {
        return fechaDeEnvio;
    }

    public void setFechaDeEnvio(Date fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }
}
