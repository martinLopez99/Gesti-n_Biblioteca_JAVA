package com.gestor.biblioteca.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "libro", schema = "bilbioteca_java")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String nombre;
    private Date fechaPublicacion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "libro_categorias",  //Este ManyToMany va a crear una clase de relacion que se va a llamar libro_categorias con dos columnas
                joinColumns = @JoinColumn(name = "libro_id"), // esta columna
                inverseJoinColumns = @JoinColumn(name = "categoria_id"), // y esta columna
            uniqueConstraints = {@UniqueConstraint(columnNames = {"libro_id,categoria_id"})}
    )
    private List<Categoria> categorias;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "libro_autores",
                joinColumns = @JoinColumn(name = "libro_id"),
                inverseJoinColumns = @JoinColumn(name = "autor_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"libro_id,autor_id"})}
    )
    private List<Autor> autores;

    @ManyToOne()
    @JoinColumn(name = "editorial_fk")
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Long id, String isbn, String nombre, Date fechaPublicacion, List<Categoria> categorias, List<Autor> autores, Editorial editorial) {
        this.id = id;
        this.isbn = isbn;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        this.categorias = categorias;
        this.autores = autores;
        this.editorial = editorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
