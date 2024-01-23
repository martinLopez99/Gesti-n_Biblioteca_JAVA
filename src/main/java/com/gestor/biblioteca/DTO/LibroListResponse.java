package com.gestor.biblioteca.DTO;
import java.util.Date;

public class LibroListResponse {
    private String isbn;
    private String nombre;
    private Date fechaPublicacion;

    public LibroListResponse() {
    }

    public LibroListResponse(String isbn, String nombre, Date fechaPublicacion) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
