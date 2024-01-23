package com.gestor.biblioteca.Repository;

import com.gestor.biblioteca.Entities.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
