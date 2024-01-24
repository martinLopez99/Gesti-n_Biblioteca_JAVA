package com.gestor.biblioteca.Services;

import com.gestor.biblioteca.DTO.LibroListResponse;
import com.gestor.biblioteca.Entities.Libro;
import com.gestor.biblioteca.Repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public List<LibroListResponse> obtenerLibros(){

        List<Libro>libros = (List<Libro>) libroRepository.findAll();

        return libros.stream()
                .map( libro -> {
                            return new LibroListResponse(libro.getNombre(),libro.getIsbn(),libro.getFechaPublicacion());
                    }
                ).collect(Collectors.toList());

    }

    public Libro obtenerLibro(Long id){
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
