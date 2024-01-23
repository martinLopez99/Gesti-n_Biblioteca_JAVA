package com.gestion.biblioteca.Repository;

import com.gestion.biblioteca.Entities.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor,Long> {
}
