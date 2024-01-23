package com.gestor.biblioteca.Repository;

import com.gestor.biblioteca.Entities.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro,Long> {
}
