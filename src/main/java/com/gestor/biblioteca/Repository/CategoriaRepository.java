package com.gestion.biblioteca.Repository;

import com.gestion.biblioteca.Entities.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
