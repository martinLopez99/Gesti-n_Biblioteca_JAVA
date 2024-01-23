package com.gestion.biblioteca.Repository;

import com.gestion.biblioteca.Entities.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro,Long> {
}
