package com.gestor.biblioteca.Services;

import com.gestor.biblioteca.Entities.Categoria;
import com.gestor.biblioteca.Repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return (List<Categoria>) categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
            return (Categoria) categoriaRepository.findById(id).get();
    }
    @Transactional
    public Categoria save(Categoria categoria){
        if (categoria.getId() != null && !categoriaRepository.existsById(categoria.getId())){
            return (Categoria) categoriaRepository.save(categoria);
        }
        throw new RuntimeException();
    }

    public boolean delete(Long id){
        if (id != null && categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
