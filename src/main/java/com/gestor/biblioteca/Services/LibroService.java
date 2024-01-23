package com.gestion.biblioteca.Services;

import com.gestion.biblioteca.Entities.Libro;
import com.gestion.biblioteca.Repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public List<Libro> findAll(){
        return (List<Libro>) libroRepository.findAll();
    }

    public Libro findAllById(Long id){
        return (Libro) libroRepository.findById(id).get();
    }

    @Transactional
    public Libro save(Libro libro){
        if (libro.getId() != null && !libroRepository.existsById(libro.getId())) {
            return libroRepository.save(libro);
        }

        throw new RuntimeException();
    }

    public boolean delete(Long id){
        if (id != null && libroRepository.existsById(id)){
            libroRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
