package com.gestor.biblioteca.Services;

import com.gestor.biblioteca.Entities.Autor;
import com.gestor.biblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> findAll(){
        return (List<Autor>) autorRepository.findAll();
    }

    public Autor findById(Long id){
            return (Autor) autorRepository.findById(id).get();
    }

    public Autor save(Autor autor){
        if (autor.getId() != null && !autorRepository.existsById(autor.getId()))
            return (Autor) autorRepository.save(autor);
        throw  new RuntimeException();
    }

    public boolean delete(Long id){
        if (id != null && autorRepository.existsById(id)){
            autorRepository.deleteById(id);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
