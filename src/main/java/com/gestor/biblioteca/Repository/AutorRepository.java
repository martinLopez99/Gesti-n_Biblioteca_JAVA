package com.gestor.biblioteca.Repository;

import com.gestor.biblioteca.Entities.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor,Long> {
}
